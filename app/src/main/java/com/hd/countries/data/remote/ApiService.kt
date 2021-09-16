package com.hd.countries.data.remote

import com.hd.countries.data.model.Country
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("all")
    suspend fun getCountries(): List<Country>

    @GET("name/{countryName}")
    suspend fun getCountry(@Path("countryName") countryName: String): List<Country>


}