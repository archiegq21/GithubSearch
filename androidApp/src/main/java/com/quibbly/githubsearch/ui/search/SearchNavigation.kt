package com.quibbly.githubsearch.ui.search

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.quibbly.common.search.SearchStore
import com.quibbly.githubsearch.ui.GithubScreens

fun NavGraphBuilder.searchNavigation(
    searchStore: SearchStore,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    composable(GithubScreens.Search.route) {
        val searchState by searchStore.searchState.collectAsState()
        val searchQuery by searchStore.searchQuery.collectAsState()

        SearchScreen(
            searchQuery = searchQuery,
            onSearchChanged = searchStore::onSearchQueryChanged,
            loadMore = searchStore::loadNextPage,
            searchState = searchState,
            navController = navController,
            modifier = modifier,
        )
    }
}