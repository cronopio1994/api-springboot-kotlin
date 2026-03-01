package org.kotlin.repository

import org.kotlin.repository.data.HotelTable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component

@Component
interface HotelRepository: CrudRepository<HotelTable, Long> {
    fun findById(id: Long): HotelRepository?
}