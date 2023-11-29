package com.example.composemapsstarter.data

import com.google.android.gms.maps.model.LatLng

class LatLngDataSource {
    private val interestingPlaces = listOf(
        LatLng(48.8566, 2.3522),    // Paris, France
        LatLng(41.9028, 12.4964),   // Rome, Italy
        LatLng(51.1657, 10.4515),   // Germany (Central coordinates)
        LatLng(41.3851, 2.1734),    // Barcelona, Spain
        LatLng(55.7558, 37.6176),   // Moscow, Russia
        LatLng(38.7223, -9.1393),   // Lisbon, Portugal
        LatLng(52.3676, 4.9041),    // Amsterdam, Netherlands
        LatLng(45.4397, 12.3317),   // Venice, Italy
        LatLng(59.3293, 18.0686),   // Stockholm, Sweden
        LatLng(53.3498, -6.2603)  ,  // Dublin, Ireland
        LatLng(-33.918861, 18.423300),  // Cape Town, South Africa
        LatLng(-1.286389, 36.817223),   // Nairobi, Kenya
        LatLng(-6.208763, 106.845599),  // Jakarta, Indonesia (Note: Partially in Africa)
        LatLng(30.044420, 31.235712),   // Cairo, Egypt
        LatLng(-25.746111, 28.188056),  // Pretoria, South Africa
        LatLng(6.524379, 3.379206),     // Lagos, Nigeria
        LatLng(33.589886, -7.603869),   // Marrakech, Morocco
        LatLng(-20.165417, 57.501086),  // Port Louis, Mauritius
        LatLng(-4.043477, 39.668206)    // Mombasa, Kenya
    )

    fun retrieveAllPlaces() : List<LatLng> = interestingPlaces.toMutableList()
}