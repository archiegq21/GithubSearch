package com.quibbly.common.domain

import kotlinx.serialization.Serializable

@Serializable
data class Response<T>(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: T,
)