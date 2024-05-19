package com.example.observecurrentlocationjetpackcompose.data.map
import com.example.observecurrentlocationjetpackcompose.data.network.WeatherDataDto
import com.example.observecurrentlocationjetpackcompose.data.network.WeatherDto
import com.example.observecurrentlocationjetpackcompose.domain.WeatherData
import com.example.observecurrentlocationjetpackcompose.domain.WeatherInfo
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, date ->
        val temperature = temperatures[index]
        val parsedDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE)
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = parsedDate,
                temperatureCelsius = temperature
            )
        )
    }.groupBy {
        it.data.time.dayOfMonth
    }.mapValues {
        it.value.map { it.data }
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDate.now()
    val currentWeatherData = weatherDataMap[now.dayOfMonth]?.firstOrNull()
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}
