package com.quibbly.githubsearch.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.google.accompanist.insets.ProvideWindowInsets
import com.quibbly.githubsearch.ui.theme.GithubSearchTheme

@Composable
fun GithubSearchApp(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    ProvideWindowInsets(
        windowInsetsAnimationsEnabled = true
    ) {
        GithubSearchTheme(
            darkTheme = darkTheme,
            content = content,
        )
    }
}