package com.example.devthink.community

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.devthink.entity.Book
import com.example.devthink.repository.dao.ContentRepository
import com.example.devthink.repository.dao.UserRepository
import com.example.devthink.util.base.BaseViewModel

class BookViewModel(
    private val contentRepository: ContentRepository = ContentRepository()
) : BaseViewModel() {

    /*private val contentRepository: ContentRepository by lazy {
        ContentRepository()
    }*/

    private val _mostBook = MutableLiveData<Book>()
    val mostBook: LiveData<Book>
        get() = _mostBook

    /*fun loadMostBook() {
        viewModelScope.loadingLaunch {
            try {
                _mostBook.value = contentRepository.loadMostBook()
                Log.d("logintestbook", mostBook.value?.name.toString())
            } catch (e: Exception) {
            }
        }
    }*/

    /*init {
        loadMostBook()
    }*/
}