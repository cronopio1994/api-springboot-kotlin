package org.kotlin.models

data class HotelResponse(
    val id: Int,
    val name: String,
    val latitude: Double? = null,
    val longitude: Double? = null
)

