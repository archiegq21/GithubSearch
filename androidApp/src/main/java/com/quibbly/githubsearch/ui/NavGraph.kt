package com.quibbly.githubsearch.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.quibbly.common.search.SearchStore
import com.quibbly.githubsearch.ui.search.searchNavigation
import com.quibbly.githubsearch.ui.view.viewRepoNavigation

@Composable
fun NavGraph(
    searchStore: SearchStore,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = GithubScreens.Search.route,
    ) {
        searchNavigation(
            searchStore = searchStore,
            navController = navController,
            modifier = modifier,
        )
        viewRepoNavigation(
            navController = navController,
            modifier = modifier,
        )
    }
}

