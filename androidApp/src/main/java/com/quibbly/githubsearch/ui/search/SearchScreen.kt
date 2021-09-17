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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.quibbly.common.search.SearchState
import com.quibbly.githubsearch.ui.GithubScreens
import com.quibbly.githubsearch.ui.assets.Github
import com.quibbly.githubsearch.ui.composables.GithubRepoCard

@Composable
fun SearchScreen(
    searchQuery: String,
    onSearchChanged: (String) -> Unit,
    loadMore: () -> Unit,
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
                                    navController.navigate(GithubScreens.ViewRepo.route)
                                },
                            )
                        }
                    }
                    if (searchState.hasNextPage) {
                        item(FooterId) {
                            LoadingFooter(
                                modifier = Modifier,
                                loadMore = loadMore
                            )
                        }
                    }
                }
                else -> EmptyPlaceHolder(modifier = Modifier.fillMaxSize())
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
                text = "Github Search",
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
                    Text("Enter Keyword")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "Clear Search",
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
                                contentDescription = "Clear Search",
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
                contentDescription = "No Result Found",
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "No Results Found",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6,
            )
            Text(
                text = "Try a new Keyword?",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.caption,
            )
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