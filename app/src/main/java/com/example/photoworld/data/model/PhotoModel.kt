package com.example.photoworld.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoModel(
    val id: String,
    val description: String?,
    val urls: PhotoUrls,
    val user: PhotoUser,
):Parcelable {
    @Parcelize
    data class PhotoUrls(
        val raw:String,
        val full:String,
        val regular:String,
        val small:String,
        val thumb:String
    ):Parcelable

    @Parcelize
    data class PhotoUser(
        val name:String,
        val username:String
    ): Parcelable{
        val atributionUrls get() = "https://unsplash.com/$username?utm_source=ImageSearchApp&utm_medium_referral"
    }
}
