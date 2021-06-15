package com.vane.android.simplecachingexample.features.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vane.android.simplecachingexample.api.RestaurantApi
import com.vane.android.simplecachingexample.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    api: RestaurantApi
) : ViewModel() {

    private val restaurantsLiveData = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> = restaurantsLiveData

    init {
        viewModelScope.launch {
            val restaurants = api.getRestaurants()
            delay(2000)
            restaurantsLiveData.value = restaurants
        }
    }
}