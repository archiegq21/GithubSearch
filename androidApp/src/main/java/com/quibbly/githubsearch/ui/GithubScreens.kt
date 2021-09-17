package com.quibbly.githubsearch.ui


sealed class GithubScreens(val route: String) {
    object Search : GithubScreens("search")
    object ViewRepo : GithubScreens("view")
}