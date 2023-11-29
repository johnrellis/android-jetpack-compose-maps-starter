package com.example.composemapsstarter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composemapsstarter.ui.theme.ComposeMapsStarterTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.AdvancedMarker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMapsStarterTheme {
                // A surface container using the 'background' color from the theme
                Map(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun Map(modifier: Modifier = Modifier) {

    val placesViewModel: PlacesViewModel =
        viewModel(factory = PlacesViewModel.Factory)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(0.0,0.0), 0f)
    }
    Column {
        Button(onClick = { placesViewModel.retrievePlaces() }) {
            Text("Load Places")
        }
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ){
            for(place in placesViewModel.places.value){
                AdvancedMarker(
                    state = MarkerState(position = place)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeMapsStarterTheme {
        Map()
    }
}