package com.example.composemapsstarter.data

import com.google.android.gms.maps.model.LatLng


interface LatLngRepository {
    suspend fun getPlaces(): List<LatLng>
}

class HardCodedLatLngRepository(private val latLngDataSource: LatLngDataSource) : LatLngRepository {
    override suspend fun getPlaces() = latLngDataSource.retrieveAllPlaces()
}