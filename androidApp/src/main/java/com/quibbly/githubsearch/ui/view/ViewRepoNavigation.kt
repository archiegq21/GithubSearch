package com.quibbly.githubsearch.ui.view

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.quibbly.common.search.SearchStore
import com.quibbly.githubsearch.ui.GithubScreens

fun NavGraphBuilder.viewRepoNavigation(
    searchStore: SearchStore,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    composable(GithubScreens.ViewRepo.route) {
        val selectedRepository by searchStore.selectedRepository.collectAsState()
        ViewRepoScreen(
            repository = selectedRepository,
            navController = navController,
            modifier = modifier,
        )
    }
}