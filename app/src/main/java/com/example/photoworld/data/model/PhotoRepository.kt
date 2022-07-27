package com.example.photoworld.data.model

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.photoworld.data.PhotoPaging.PhotoPagingSource
import com.example.photoworld.data.api.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepository @Inject constructor(private val apiService: ApiService) {

    fun getSearchResult(query: String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = false
        ), pagingSourceFactory = { PhotoPagingSource(apiService, query) }
    ).liveData
}