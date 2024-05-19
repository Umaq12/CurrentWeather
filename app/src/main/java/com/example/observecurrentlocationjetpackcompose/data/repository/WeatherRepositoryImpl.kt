package com.example.observecurrentlocationjetpackcompose.data.repository

import com.example.observecurrentlocationjetpackcompose.data.map.toWeatherInfo
import com.example.observecurrentlocationjetpackcompose.data.network.ApiService
import com.example.observecurrentlocationjetpackcompose.domain.WeatherInfo
import com.example.observecurrentlocationjetpackcompose.domain.repository.WeatherRepository
import com.example.observecurrentlocationjetpackcompose.domain.util.Resource
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
    private val api: ApiService
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}
