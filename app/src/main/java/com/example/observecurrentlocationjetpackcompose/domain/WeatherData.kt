package com.example.observecurrentlocationjetpackcompose.domain

import java.time.LocalDate

data class WeatherData(
    val time: LocalDate,
    val temperatureCelsius: Double,
)
