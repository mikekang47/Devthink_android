package com.example.devthink.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.devthink.util.base.BaseViewModel

class HomeViewModel : BaseViewModel(){
    private val _isRightPaneOpen = MutableLiveData<Boolean>(false)

    val isRightPaneOpen: LiveData<Boolean>
        get() = _isRightPaneOpen

    fun openRightPane() {
        _isRightPaneOpen.value = true
    }

    fun closeRightPane() {
        _isRightPaneOpen.value = false
    }

    fun onBackPressed(): Boolean {
        return when {
            isRightPaneOpen.value == true -> {
                closeRightPane()
                true
            }
            else -> {
                false
            }
        }
    }

    init {
        closeRightPane()
    }
}