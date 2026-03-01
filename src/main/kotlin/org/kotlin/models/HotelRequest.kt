package org.kotlin.models

data class HotelRequest(
    val name: String,
    val latitude: Double? = null,
    val longitude: Double? = null
)
