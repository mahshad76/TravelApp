package com.mahshad.network

import com.mahshad.model.dto.CountryDto
import retrofit2.http.GET

interface ApiService {
    @GET("name/peru")
    suspend fun getCountries(): retrofit2.Response<List<CountryDto>>
}