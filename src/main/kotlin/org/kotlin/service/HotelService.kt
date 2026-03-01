package org.kotlin.service

import org.kotlin.repository.HotelRepository
import org.kotlin.repository.data.HotelTable
import org.springframework.stereotype.Component

@Component
class HotelService(
    val hotelRepository: HotelRepository
) {
    fun createHotel(){
        hotelRepository.save(HotelTable(id=null,name="h1"))
    }
    fun getHotelById(id: Long): HotelTable?{
        TODO("implement")
    }
}