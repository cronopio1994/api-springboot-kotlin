package org.kotlin.repository

import org.kotlin.repository.data.HotelTable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HotelRepository : CrudRepository<HotelTable, Long> {
    fun findByDeletedFalse(): List<HotelTable>
    fun findByHotelId(hotelId: Long): HotelTable
}