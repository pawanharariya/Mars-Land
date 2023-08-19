package com.example.android.marsrealestate.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsrealestate.network.MarsApi
import com.example.android.marsrealestate.network.MarsProperty
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _properties = MutableLiveData<List<MarsProperty>>()
    val properties: LiveData<List<MarsProperty>>
        get() = _properties

    init {
        getMarsRealEstateProperties()
    }

    private fun getMarsRealEstateProperties() {
        viewModelScope.launch {
            try {
                val listResult = MarsApi.retrofitService.getProperties()
                _status.value = "Success: ${listResult.size}"
                if (listResult.isNotEmpty()) {
                    _properties.value = listResult
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}
