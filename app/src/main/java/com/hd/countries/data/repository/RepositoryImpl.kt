package com.hd.countries.data.repository

import com.hd.countries.data.model.Country
import com.hd.countries.data.remote.ApiService
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val apiService: ApiService) : Repository {
    override suspend fun getCountries(): List<Country> {
        return apiService.getCountries()
    }

    override suspend fun getCountry(countryName: String): List<Country> {
        return apiService.getCountry(countryName)
    }
}