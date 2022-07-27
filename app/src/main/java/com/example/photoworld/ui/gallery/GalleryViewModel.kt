package com.example.photoworld.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.photoworld.DEFAULT_QUERY
import com.example.photoworld.data.model.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val repository: PhotoRepository) : ViewModel() {

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photo = currentQuery.switchMap { queryString ->
        repository.getSearchResult(queryString).cachedIn(viewModelScope)
    }

    fun searchPhoto(query:String){
        currentQuery.value = query
    }
}