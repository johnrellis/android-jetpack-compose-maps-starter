package com.example.composemapsstarter

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.composemapsstarter.data.LatLngRepository
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch

private val TAG = "ComposePlaces"

class PlacesViewModel(private val latLngRepository: LatLngRepository): ViewModel() {


    /** The mutable State that stores the status of the most recent request */
    val places = mutableStateOf<List<LatLng>>(emptyList())

    fun retrievePlaces(){
        viewModelScope.launch {
            Log.d(TAG, "Retrieving places")
            val retrievedPlaces = latLngRepository.getPlaces()
            Log.d(TAG, retrievedPlaces.size.toString())
            places.value = retrievedPlaces
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MapsComposeApplication)
                val latLngRepository = application.container.latLngRepository
                PlacesViewModel(latLngRepository = latLngRepository)
            }
        }
    }
}