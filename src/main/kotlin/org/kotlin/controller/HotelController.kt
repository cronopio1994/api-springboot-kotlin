package org.kotlin.controller

import org.kotlin.models.HotelRequest
import org.kotlin.models.HotelResponse
import org.kotlin.service.HotelService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/hotel")
class HotelController(
    private val hotelService: HotelService
) {
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    fun createHotel( @RequestBody hotelRequest: HotelRequest): ResponseEntity<HotelResponse> {
        val createdHotel = hotelService.createHotel(hotelRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel)
    }

    @GetMapping("/{hotelId}")
    fun getHotel(
        @PathVariable hotelId: Int
    ): ResponseEntity<HotelResponse> {
        return ResponseEntity.ok(hotelService.getHotelById(hotelId))
    }

    @GetMapping
    fun getAllHotels(): ResponseEntity<List<HotelResponse>> {
        return ResponseEntity.ok(hotelService.getAllHotels())
    }

    @DeleteMapping("/{hotelId}")
    fun deleteHotel(
        @PathVariable hotelId: Int
    ): ResponseEntity<Unit> {
        hotelService.deleteHotelById(hotelId)
        return ResponseEntity.noContent().build()

    }
    @GetMapping("/nearest")
    fun getNearestHotels(
        @RequestParam lat: Double,
        @RequestParam lon: Double,
        @RequestParam radius: Double
    ): ResponseEntity<List<HotelResponse>> {

        val hotels = hotelService.findNearestHotels(lat, lon, radius)
        return ResponseEntity.ok(hotels)
    }
}