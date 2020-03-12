package com.san.backend.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Exercise(
    @SerializedName("id") override val id: String,
    @SerializedName("description") val description: String,
    @SerializedName("name") val name: String,
    @SerializedName("category") val category: String,
    @SerializedName("equipment") val equipment: String
) : WithId, Parcelable
