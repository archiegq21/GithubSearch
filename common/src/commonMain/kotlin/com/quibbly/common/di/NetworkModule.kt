package com.quibbly.common.di

import com.quibbly.common.network.HttpClient
import io.ktor.http.URLProtocol.Companion.HTTPS
import kotlinx.serialization.json.Json
import org.koin.dsl.module

fun networkModule() = module {

    single {
        Json {
            allowStructuredMapKeys = true
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
    }

    single {
        HttpClient(
            urlProtocol = HTTPS,
            baseUrl = "api.github.com",
            json = get(),
        )
    }

}