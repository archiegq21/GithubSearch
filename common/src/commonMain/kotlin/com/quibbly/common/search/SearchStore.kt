package com.quibbly.common.search

import com.quibbly.common.domain.GithubSearchRepository
import com.quibbly.common.domain.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

@OptIn(
    FlowPreview::class,
    ExperimentalCoroutinesApi::class,
)
class SearchStore(
    private val storeScope: CoroutineScope,
) : KoinComponent {

    private val searchRepository: GithubSearchRepository = get()

    private val _selectedRepository = MutableStateFlow<Repository?>(null)
    val selectedRepository = _selectedRepository.asStateFlow()

    private val _searchState = MutableStateFlow(SearchState())
    val searchState = _searchState.asStateFlow()

    private val nextPageEvent = MutableSharedFlow<Int>()
    private val retryEvent = MutableSharedFlow<Unit>()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    init {
        searchQuery.debounce(300)
            .distinctUntilChanged()
            .filter { it.isNotEmpty() }
            .flatMapLatest { query ->
                nextPageEvent
                    .onStart { emit(1) }
                    .runningReduce { accumulator, value ->
                        accumulator + value
                    }.searchResultFlow(query)
            }.onEach {
                _searchState.value = it
            }.launchIn(storeScope)
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun loadNextPage() {
        if (searchState.value.loading) return
        storeScope.launch {
            nextPageEvent.emit(1)
        }
    }

    fun retry() {
        if (searchState.value.loading) return
        storeScope.launch {
            retryEvent.emit(Unit)
        }
    }

    fun selectedRepository(repository: Repository) {
        _selectedRepository.value = repository
    }

    private fun Flow<Int>.searchResultFlow(
        query: String,
    ): Flow<SearchState> = flatMapLatest { page ->
        retryEvent.onStart { emit(Unit) }
            .flatMapLatest {
                flow {
                    emit(searchState.value.copy(loading = true, error = null))

                    val result = searchRepository.searchRepository(
                        query = query,
                        page = page,
                        countPerPage = CountPerPage,
                    )

                    result.fold({ newSearchResult ->
                        val searchResult = if (page <= 1) newSearchResult else
                            searchState.value.searchResult + newSearchResult

                        emit(
                            searchState.value.copy(
                                loading = false,
                                searchResult = searchResult,
                                error = null,
                                hasNextPage = newSearchResult.size >= CountPerPage
                            )
                        )
                    }, {
                        emit(
                            searchState.value.copy(
                                loading = false,
                                error = it,
                                hasNextPage = false,
                            )
                        )
                    })
                }
            }
    }

    companion object {
        private const val CountPerPage = 30
    }
}

data class SearchState(
    val searchResult: List<Repository> = emptyList(),
    val loading: Boolean = false,
    val error: Throwable? = null,
    val hasNextPage: Boolean = false,
)