package com.san.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Workout(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "time_started") val timeStarted: String,
    @ColumnInfo(name = "time_ended") val timeEnded: String = "0"
)