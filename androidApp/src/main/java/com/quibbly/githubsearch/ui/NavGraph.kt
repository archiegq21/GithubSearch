package com.quibbly.githubsearch.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.quibbly.githubsearch.ui.search.searchNavigation

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = GithubScreens.Search.route,
    ) {
        searchNavigation(
            navController = navController,
            modifier = modifier,
        )
    }
}

