package com.quibbly.common.di

import com.quibbly.common.domain.GithubSearchRemoteSource
import com.quibbly.common.domain.GithubSearchRemoteSourceImpl
import com.quibbly.common.domain.GithubSearchRepository
import com.quibbly.common.domain.GithubSearchRepositoryImpl
import org.koin.dsl.module

fun githubModule() = module {

    single<GithubSearchRemoteSource> {
        GithubSearchRemoteSourceImpl(get())
    }

    single<GithubSearchRepository> {
        GithubSearchRepositoryImpl(get())
    }

}