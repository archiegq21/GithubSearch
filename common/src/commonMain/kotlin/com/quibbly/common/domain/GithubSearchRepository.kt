package com.quibbly.common.domain

interface GithubSearchRepository {
    suspend fun searchRepository(
        query: String,
        page: Int,
        countPerPage: Int,
    ): Result<List<Repository>>
}

class GithubSearchRepositoryImpl(
    private val remoteSource: GithubSearchRemoteSource,
): GithubSearchRepository {

    override suspend fun searchRepository(
        query: String,
        page: Int,
        countPerPage: Int,
    ) = remoteSource.searchRepository(query, page, countPerPage)

}