package org.kotlin.controller

import org.kotlin.models.HotelRequest
import org.kotlin.models.HotelResponse
import org.kotlin.service.HotelService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/hotel")
class HotelController(
    private val hotelService: HotelService
) {
    @PostMapping()
    fun createHotel(hotelRequest: HotelRequest): ResponseEntity<HotelResponse> {
        val createdHotel = hotelService.createHotel(hotelRequest)
        return ResponseEntity.status(201).body(createdHotel)
    }

    @GetMapping("/{hotelId}")
    fun getHotel(
        @PathVariable hotelId: Long
    ): ResponseEntity<HotelResponse> {
        return ResponseEntity.ok(hotelService.getHotelById(hotelId))
    }

    @DeleteMapping("/{hotelId}")
    fun deleteHotel(
        @PathVariable hotelId: Long
    ): ResponseEntity<Unit> {
        hotelService.deleteHotelById(hotelId)
        return ResponseEntity.noContent().build()

    }
}