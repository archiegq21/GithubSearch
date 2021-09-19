package com.quibbly.githubsearch.ui.view

import android.content.res.Configuration
import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebSettingsCompat.FORCE_DARK_OFF
import androidx.webkit.WebSettingsCompat.FORCE_DARK_ON
import androidx.webkit.WebViewFeature
import com.quibbly.common.domain.Repository

@Composable
fun ViewRepoScreen(
    repository: Repository?,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                    when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                        Configuration.UI_MODE_NIGHT_YES -> {
                            WebSettingsCompat.setForceDark(settings, FORCE_DARK_ON)
                        }
                        Configuration.UI_MODE_NIGHT_NO, Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                            WebSettingsCompat.setForceDark(settings, FORCE_DARK_OFF)
                        }
                        else -> { /* Use Default */ }
                    }
                }
            }
        }
    ) {
        repository?.run {
            it.loadUrl(url)
        }
    }
}