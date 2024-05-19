package com.example.observecurrentlocationjetpackcompose.domain.location

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}