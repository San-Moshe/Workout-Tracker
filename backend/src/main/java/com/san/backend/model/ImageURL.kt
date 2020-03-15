package com.san.backend.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageURL(
    @SerializedName("exercise") val exercise: String,
    @SerializedName("image") val imageURL: String
) : Parcelable