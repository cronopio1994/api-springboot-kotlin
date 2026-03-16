package org.kotlin.repository

import org.kotlin.repository.data.HotelTable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HotelRepository : CrudRepository<HotelTable, Int> {
    fun findByIdAndDeletedFalse(id: Int): HotelTable?
    fun findByDeletedFalse(): List<HotelTable>
    fun getAllByDeletedFalse(): List<HotelTable>
}