package com.quibbly.common.network

import io.ktor.client.*

suspend fun <T> HttpClient.runCatching(
    request: suspend HttpClient.() -> T
): Result<T> = try {
    val response = request()
    Result.success(response)
} catch (e: Throwable) {
    Result.failure(e)
}