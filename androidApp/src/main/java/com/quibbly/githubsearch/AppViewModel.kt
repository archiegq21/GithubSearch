package com.quibbly.githubsearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quibbly.common.search.SearchStore

class AppViewModel : ViewModel() {

    val searchStore = SearchStore(
        storeScope = viewModelScope,
    );

}