package com.example.composemapsstarter.app

import com.example.composemapsstarter.data.HardCodedLatLngRepository
import com.example.composemapsstarter.data.LatLngDataSource
import com.example.composemapsstarter.data.LatLngRepository


interface AppContainer {
    val latLngRepository: LatLngRepository
}

class DefaultAppContainer: AppContainer {
    override val latLngRepository: LatLngRepository by lazy {
        HardCodedLatLngRepository(LatLngDataSource())
    }
}