package com.quibbly.githubsearch.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.quibbly.common.search.SearchStore

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainContent(
    searchStore: SearchStore,
) {
    val navController = rememberNavController()

    GithubSearchApp {
        NavGraph(
            searchStore = searchStore,
            navController = navController,
            modifier = Modifier.fillMaxSize(),
        )
    }

}