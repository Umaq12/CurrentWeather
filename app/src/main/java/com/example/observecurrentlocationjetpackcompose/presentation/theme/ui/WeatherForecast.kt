package com.example.observecurrentlocationjetpackcompose.presentation.theme.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    val dailyWeatherData = state.weatherInfo?.weatherDataPerDay?.flatMap { it.value } ?: emptyList()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(dailyWeatherData) { weatherData ->
                WeeklyWeatherDisplay(
                    weatherData = weatherData,
                    modifier = Modifier
                        .height(100.dp)
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}
