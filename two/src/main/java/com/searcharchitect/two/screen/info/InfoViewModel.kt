package com.searcharchitect.two.screen.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.searcharchitect.two.screen.search.SearchState
import javax.inject.Inject

class InfoViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableLiveData<InfoState>(InfoState.Default)
    val state: LiveData<InfoState> get() = _state

}