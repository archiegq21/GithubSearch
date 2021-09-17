package com.quibbly.common.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Repository(
    val id: Int,
    val name: String,
    @SerialName("full_name") val fullname: String,
    @SerialName("html_url") val url: String,
    val description: String = "",
    @SerialName("forks") val forksCount: Int = 0,
    @SerialName("open_issues") val issuesCount: Int = 0,
    @SerialName("watchers") val watchersCount: Int = 0,
    val score: Float = 0.0f,
    val owner: Owner,
)


@Serializable
data class Owner(
    @SerialName("login") val name: String,
    val id: Int,
    val avatar_url: String,
)