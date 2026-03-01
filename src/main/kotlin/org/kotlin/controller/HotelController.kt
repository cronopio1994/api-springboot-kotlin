package org.kotlin.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HotelController {
    @GetMapping("v1/hotel/{hotelId}")
    fun getHotel(
        @PathVariable("hotelId") hotelId: Int
    ): ResponseEntity<String>{
        return ResponseEntity.ok("Hot el $hotelId")
    }
}