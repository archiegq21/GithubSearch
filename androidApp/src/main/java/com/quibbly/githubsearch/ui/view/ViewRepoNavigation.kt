package com.quibbly.githubsearch.ui.view

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.quibbly.githubsearch.ui.GithubScreens

fun NavGraphBuilder.viewRepoNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    composable(GithubScreens.ViewRepo.route) {
        ViewRepoScreen(
            navController = navController,
            modifier = modifier,
        )
    }
}