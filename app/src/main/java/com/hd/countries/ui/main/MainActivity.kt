package com.hd.countries.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.hd.countries.ui.components.Toolbar
import com.hd.countries.ui.theme.CountriesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CountriesTheme {
                val state = mainViewModel.state.value
                Column(modifier = Modifier.fillMaxSize()) {
                    Toolbar(title = "Countries")
                    Box(modifier = Modifier.weight(1f)) {
                        state.countries?.let {
                            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                                items(it) { country ->
                                    CountryListItem(this@MainActivity,country) {

                                    }
                                }

                            }
                        }

                        if (state.isLoading) {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center),color = Color.Black)
                        }

                    }
                }
                // A surface container using the 'background' color from the theme
                //Surface(color = MaterialTheme.colors.background) {
                /*mainViewModel.getCountries().observe(this, {
                    *//*Greeting("Android")*//*
                        *//*it.data?.forEach {
                            it.name?.log()
                        }*//*
                    })*/


                // }


            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CountriesTheme {
        Greeting("Android")
    }
}