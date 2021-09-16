package com.quibbly.githubsearch.ui.search

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.quibbly.githubsearch.ui.GithubScreens

fun NavGraphBuilder.searchNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    composable(GithubScreens.Search.route) {
        SearchScreen(
            navController = navController,
            modifier = modifier,
        )
    }
}