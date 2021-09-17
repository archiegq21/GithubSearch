package com.quibbly.common.search

import com.quibbly.common.domain.GithubSearchRepository
import com.quibbly.common.domain.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

@OptIn(
    FlowPreview::class,
    ExperimentalCoroutinesApi::class,
)
class SearchStore(
    private val storeScope: CoroutineScope,
): KoinComponent {

    private val searchRepository: GithubSearchRepository = get()

    private val _searchState = MutableStateFlow(SearchState())
    val searchState = _searchState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _currentPage = MutableStateFlow(1)

    init {
        searchQuery.debounce(300)
            .distinctUntilChanged()
            .onEach {
                _currentPage.value = 1
            }
            .filter { it.isNotEmpty() }
            .flatMapLatest {
                searchResultFlow(it)
            }.onEach {
                _searchState.value = it
            }.launchIn(storeScope)
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun loadNextPage() {
        if (!_searchState.value.loading) {
            _currentPage.value += 1
        }
    }

    private fun searchResultFlow(
        query: String,
    ): Flow<SearchState> = _currentPage.flatMapLatest { page ->
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