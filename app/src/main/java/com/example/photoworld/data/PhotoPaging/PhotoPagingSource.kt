package com.example.photoworld.data.PhotoPaging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.photoworld.STARTING_PAGE_INDEX
import com.example.photoworld.data.api.ApiService
import com.example.photoworld.data.model.PhotoModel
import retrofit2.HttpException
import java.io.IOException

class PhotoPagingSource(
    private val apiService: ApiService,
    private val query: String
) : PagingSource<Int, PhotoModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoModel> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = apiService.searchPhoto(query, position, params.loadSize)
            val photos = response.results
            LoadResult.Page(
                data = photos,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PhotoModel>): Int? {
        TODO("Not yet implemented")
    }

}