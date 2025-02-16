package com.example.observecurrentlocationjetpackcompose.data.network

import com.squareup.moshi.Json

data class WeatherDataDto(
    val time: List<String>,
    @field:Json(name = "temperature_2m_max")
    val temperatures: List<Double>,
)
