package com.example.observecurrentlocationjetpackcompose.data.network

import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "daily")
    val weatherData: WeatherDataDto
)