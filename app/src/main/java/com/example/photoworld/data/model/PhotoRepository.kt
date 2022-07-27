package com.example.photoworld.data.model

import com.example.photoworld.data.api.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepository @Inject constructor(private val apiService: ApiService) {
}