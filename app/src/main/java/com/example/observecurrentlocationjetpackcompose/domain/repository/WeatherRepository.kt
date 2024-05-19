package com.example.observecurrentlocationjetpackcompose.domain.repository

import com.example.observecurrentlocationjetpackcompose.domain.WeatherInfo
import com.example.observecurrentlocationjetpackcompose.domain.util.Resource
import retrofit2.Response

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>

}