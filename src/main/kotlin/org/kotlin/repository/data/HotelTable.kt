package org.kotlin.repository.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.kotlin.models.HotelResponse

@Entity
@Table(name = "hotels")
data class HotelTable(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(name = "name")
    val name: String = "",
    val latitude: Double? = null,
    val longitude: Double? = null,
    var deleted: Boolean = false
) {

    fun toHotelResponse(): HotelResponse {
        return HotelResponse(
            id = this.id!!,
            name = this.name,
            latitude = this.latitude,
            longitude = this.longitude
        )
    }
}