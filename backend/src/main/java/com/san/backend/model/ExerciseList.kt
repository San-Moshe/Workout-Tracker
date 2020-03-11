package com.san.backend.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExerciseList(
    @SerializedName("_id") override val id: String,
    @SerializedName("description") val description: String,
    @SerializedName("url") val url: String,
    @SerializedName("who") val who: String
) : WithId, Parcelable
