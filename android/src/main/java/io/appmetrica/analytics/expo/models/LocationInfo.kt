package io.appmetrica.analytics.expo.models

import android.location.Location
import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record

class LocationInfo : Record {
    @Field
    val latitude: Double = 0.0

    @Field
    val longitude: Double = 0.0

    @Field
    val altitude: Double? = null

    @Field
    val accuracy: Float? = null

    @Field
    val course: Float? = null

    @Field
    val speed: Float? = null

    @Field
    val timestamp: Long? = null

    @Field
    val verticalAccuracy: Float? = null

    fun toLocation(): Location {
        val location = Location("Custom")
        location.latitude = latitude
        location.longitude = longitude
        altitude?.let { location.longitude = it }
        accuracy?.let { location.accuracy = it }
        course?.let { location.bearing = it }
        speed?.let { location.speed = it }
        timestamp?.let { location.time = it }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            verticalAccuracy?.let { location.verticalAccuracyMeters = it }
        }
        return location
    }
}