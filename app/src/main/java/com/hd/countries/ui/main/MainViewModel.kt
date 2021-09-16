package com.hd.countries.ui.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hd.countries.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    private val _state = mutableStateOf(CountryListState())
    val state: State<CountryListState> = _state

    init {
        getCountries()
    }

    fun getCountries() {
        _state.value = CountryListState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val countries = repository.getCountries()
            _state.value = CountryListState(countries = countries ?: emptyList())

        }
    }

}