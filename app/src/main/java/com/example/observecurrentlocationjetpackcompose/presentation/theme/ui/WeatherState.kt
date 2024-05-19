package com.example.observecurrentlocationjetpackcompose.presentation.theme.ui

import com.example.observecurrentlocationjetpackcompose.domain.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)