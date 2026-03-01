package org.kotlin.service

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
        return hotelRepository.save(
            HotelTable(
                name = newHotel.name,
                latitude = newHotel.latitude,
                longitude = newHotel.longitude
            )
        ).toHotelResponse()


    }

    fun getHotelById(id: Long): HotelResponse? {
        return hotelRepository.findById(id).orElseThrow {
            RuntimeException("Hotel not found with id $id")
        }.toHotelResponse()
    }

    fun deleteHotelById(id: Long) {
        val hotel = hotelRepository.findByHotelId(id)
        hotel.deleted = true
        hotelRepository.save(hotel)
    }


}