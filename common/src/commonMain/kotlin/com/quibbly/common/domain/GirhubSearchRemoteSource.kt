package com.quibbly.common.domain

import com.quibbly.common.network.runCatching
import io.ktor.client.*
import io.ktor.client.request.*

interface GithubSearchRemoteSource {
    suspend fun searchRepository(
        query: String,
        page: Int,
        countPerPage: Int,
    ): Result<List<Repository>>
}

class GithubSearchRemoteSourceImpl(
    private val httpClient: HttpClient,
): GithubSearchRemoteSource {

    override suspend fun searchRepository(
        query: String,
        page: Int,
        countPerPage: Int,
    ) = httpClient.runCatching {
        get<Response<List<Repository>>>("/search/repositories") {
            parameter("q", query)
            parameter("per_page", countPerPage)
            parameter("page", page)
        }
    }.map { it.items }

}