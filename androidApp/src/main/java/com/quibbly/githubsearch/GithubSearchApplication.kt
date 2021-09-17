package com.quibbly.githubsearch

import android.app.Application
import com.quibbly.common.di.initKoin
import org.koin.core.Koin

class GithubSearchApplication : Application() {

    private lateinit var koin: Koin

    override fun onCreate() {
        super.onCreate()
        koin = initKoin().koin
    }

}