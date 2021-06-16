package com.vane.android.simplecachingexample.features.restaurants

import androidx.lifecycle.*
import com.vane.android.simplecachingexample.api.RestaurantApi
import com.vane.android.simplecachingexample.data.Restaurant
import com.vane.android.simplecachingexample.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()

}