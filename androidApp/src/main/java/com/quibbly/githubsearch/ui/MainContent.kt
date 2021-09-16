package com.quibbly.githubsearch.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainContent() {
    val navController = rememberNavController()

    GithubSearchApp {
        NavGraph(
            navController = navController,
            modifier = Modifier.fillMaxSize(),
        )
    }

}