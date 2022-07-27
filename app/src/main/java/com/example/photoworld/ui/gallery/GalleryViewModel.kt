package com.example.photoworld.ui.gallery

import androidx.lifecycle.ViewModel
import com.example.photoworld.data.model.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor (private val repository: PhotoRepository):ViewModel() {

}