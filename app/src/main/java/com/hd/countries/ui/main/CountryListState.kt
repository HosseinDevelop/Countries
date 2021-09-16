package com.hd.countries.ui.main

import com.hd.countries.data.model.Country

data class CountryListState (
    val isLoading:Boolean=false,
    val countries:List<Country>? = emptyList(),
    val error:String=""
)
