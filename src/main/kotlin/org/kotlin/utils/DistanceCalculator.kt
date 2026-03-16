package org.kotlin.utils

import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

object DistanceCalculator {
    //uses Harversine formula to calculate the shortest distance between 2 points in the earth surface knowing their latitudes and longitudes

    private const val EARTH_RADIUS = 6371 // km

    fun distanceBetweenTwoPlacesInKm(
        lat1: Double, //latitude 1
        lon1: Double, // longitude 1
        lat2: Double, //latitude 2
        lon2: Double // longitude 1
    ): Double {
    //Formula
//        d-lat = (lat2-lat1)
//        d-lon = (long2-long1)
//        a = sin^2(d-lat/2) + cos(lat1)x cos(lat2) X sin^2(d-lon/2)
//        c = 2 x atan2((a)^1/2, (1-a)^1/2)
//        d = EARTH_RADIUSxc

        //convert from decimal to radians
        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)

        val a = sin(dLat / 2).pow(2) +
                cos(Math.toRadians(lat1)) *
                cos(Math.toRadians(lat2)) *
                sin(dLon / 2).pow(2)

        val c = 2 * atan2(sqrt(a), sqrt(1 - a))

        return EARTH_RADIUS * c
    }
}