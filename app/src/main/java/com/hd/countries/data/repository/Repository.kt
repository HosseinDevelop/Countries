package com.hd.countries.data.repository

import com.hd.countries.data.model.Country

interface Repository {

    suspend fun getCountries(): List<Country>

    suspend fun getCountry(countryName: String): List<Country>
}