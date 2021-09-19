package com.quibbly.githubsearch.ui.search

import androidx.compose.animation.*
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.quibbly.common.domain.Repository
import com.quibbly.common.search.SearchState
import com.quibbly.githubsearch.R
import com.quibbly.githubsearch.ui.GithubScreens
import com.quibbly.githubsearch.ui.assets.Github
import com.quibbly.githubsearch.ui.composables.GithubRepoCard

@Composable
fun SearchScreen(
    searchQuery: String,
    onSearchChanged: (String) -> Unit,
    loadMore: () -> Unit,
    retry: () -> Unit,
    repositorySelected: (Repository) -> Unit,
    searchState: SearchState,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val lazyListState = rememberLazyListState()
    Scaffold(
        modifier = modifier,
        topBar = {
            SearchTopBar(
                searchQuery = searchQuery,
                onSearchChanged = onSearchChanged,
                modifier = Modifier,
            )
        },
    ) {
        Crossfade(targetState = searchState) {
            when {
                it.searchResult.isEmpty() && it.loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        CircularProgressIndicator()
                    }
                }
                it.searchResult.isNotEmpty() -> LazyColumn(
                    state = lazyListState,
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    searchState.searchResult.forEach { repo ->
                        item {
                            GithubRepoCard(
                                repository = repo,
                                onClick = {
                                    repositorySelected(repo)
                                    navController.navigate(GithubScreens.ViewRepo.route)
                                },
                            )
                        }
                    }
                    when {
                        searchState.error != null -> {
                            item(ErrorFooterId) {
                                ErrorFooter(
                                    modifier = Modifier,
                                    loading = searchState.loading,
                                    retry = retry,
                                )
                            }
                        }
                        searchState.hasNextPage -> {
                            item(FooterId) {
                                LoadingFooter(
                                    modifier = Modifier,
                                    loadMore = loadMore
                                )
                            }
                        }
                    }
                }
                else -> EmptyPlaceHolder(
                    modifier = Modifier.fillMaxSize(),
                    hasError = searchState.error != null,
                    retry = retry,
                )
            }
        }
    }
}

@OptIn(
    ExperimentalAnimationApi::class,
    ExperimentalComposeUiApi::class,
)
@Composable
private fun SearchTopBar(
    searchQuery: String,
    onSearchChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val searchTextFieldInteractionSource = remember { MutableInteractionSource() }
    val searchTextFieldFocused by searchTextFieldInteractionSource.collectIsFocusedAsState()
    val searchCorners by animateIntAsState(targetValue = if (searchTextFieldFocused) 10 else 50)
    val searchShape by remember { derivedStateOf { RoundedCornerShape(searchCorners) } }

    Surface(
        modifier = modifier.wrapContentHeight(),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 16.dp,
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = stringResource(R.string.github_search),
                style = MaterialTheme.typography.h6,
            )
            val keyboardController = LocalSoftwareKeyboardController.current
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(searchShape),
                value = searchQuery,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                ),
                onValueChange = onSearchChanged,
                interactionSource = searchTextFieldInteractionSource,
                singleLine = true,
                maxLines = 1,
                label = {
                    Text(stringResource(R.string.search_hint))
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = stringResource(R.string.search),
                    )
                },
                trailingIcon = {
                    AnimatedVisibility(
                        visible = searchQuery.isNotEmpty(),
                        enter = fadeIn(),
                        exit = fadeOut(),
                    ) {
                        IconButton(onClick = {
                            onSearchChanged("")
                        }) {
                            Icon(
                                imageVector = Icons.Rounded.Close,
                                contentDescription = stringResource(R.string.clear_search),
                            )
                        }
                    }
                },
                shape = searchShape,
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )
        }
    }
}

@Composable
private fun EmptyPlaceHolder(
    modifier: Modifier = Modifier,
    hasError: Boolean,
    retry: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.disabled,
        ) {
            Icon(
                modifier = Modifier.size(75.dp),
                imageVector = Icons.Github,
                contentDescription = stringResource(id = R.string.no_results_found),
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = if (hasError) {
                    stringResource(id = R.string.default_error)
                } else {
                    stringResource(id = R.string.no_results_found)
                },
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6,
            )
            if (hasError) {
                TextButton(onClick = retry) {
                    Text(stringResource(id = R.string.try_again))
                }
            } else {
                Text(
                    text = stringResource(id = R.string.try_new_keyword),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                )
            }
        }
    }
}

@Composable
fun LoadingFooter(
    modifier: Modifier = Modifier,
    loadMore: () -> Unit,
) {
    SideEffect(loadMore)
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

private const val FooterId = "FooterId"

@Composable
fun ErrorFooter(
    modifier: Modifier = Modifier,
    loading: Boolean = false,
    retry: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (!loading) {
            Text(
                text = stringResource(id = R.string.default_error)
            )
            TextButton(onClick = retry) {
                Text(stringResource(id = R.string.try_again))
            }
        } else {
            CircularProgressIndicator()
        }
    }
}

private const val ErrorFooterId = "ErrorFooterId"