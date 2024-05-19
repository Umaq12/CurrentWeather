package com.example.observecurrentlocationjetpackcompose.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/forecast?current=temperature_2m&daily=temperature_2m_max")

    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherDto
}