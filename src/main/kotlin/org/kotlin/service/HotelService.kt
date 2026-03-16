package org.kotlin.service

import org.kotlin.exceptions.HotelNotFoundException
import org.kotlin.models.HotelRequest
import org.kotlin.models.HotelResponse
import org.kotlin.repository.HotelRepository
import org.kotlin.repository.data.HotelTable
import org.springframework.stereotype.Component

@Component
class HotelService(
    val hotelRepository: HotelRepository
) {
    fun createHotel(newHotel: HotelRequest): HotelResponse {
        try {
            return hotelRepository.save(
                HotelTable(
                    name = newHotel.name,
                    latitude = newHotel.latitude,
                    longitude = newHotel.longitude
                )
            ).toHotelResponse()
        } catch (e: Exception) {
            throw RuntimeException("Something went wrong creating the hotel", e)
        }

    }

    fun getHotelById(id: Int): HotelResponse? {
        return hotelRepository.findById(id).orElseThrow {
            HotelNotFoundException("Hotel with id $id not found")
        }.toHotelResponse()
    }

    fun deleteHotelById(id: Int) {
        val hotel = hotelRepository.findByIdAndDeletedFalse(id) ?: throw HotelNotFoundException("Hotel with id $id not found")
        hotel.deleted = true
        hotelRepository.save(hotel)
    }


}