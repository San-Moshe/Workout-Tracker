package com.san.room.converters

import androidx.room.TypeConverter

class ListConverter {
    @TypeConverter
    fun fromList(value: List<String>): String {
        return value.joinToString(separator = " ")
    }

    @TypeConverter
    fun toList(value: String): List<String> {
        return value.trim().split(" ").toList()
    }
}