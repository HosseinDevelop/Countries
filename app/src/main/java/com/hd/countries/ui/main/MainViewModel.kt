package com.hd.countries.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hd.countries.common.Resource
import com.hd.countries.data.model.Country
import com.hd.countries.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    fun getCountries(): LiveData<Resource<List<Country>>> {
        val countries = MutableLiveData<Resource<List<Country>>>()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                countries.postValue(Resource.Loading<List<Country>>())
                countries.postValue(Resource.Success<List<Country>>(repository.getCountries()))
            } catch (e: HttpException) {
                countries.postValue(Resource.Error<List<Country>>(e.localizedMessage ?: "An unexpected error occurred"))
            } catch (e: IOException) {
                countries.postValue(Resource.Error<List<Country>>("couldn't reach server. check your internet connection"))
            }
        }


        return countries

    }

}