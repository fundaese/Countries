package com.example.countries.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.countries.model.Country
import com.example.countries.service.CountryDatabase
import kotlinx.coroutines.launch

class CountryViewModel(application: Application) : BaseViewModel(application) {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(uuId : Int) {
        launch {
            val dao = CountryDatabase(getApplication()).countryDao()
            val country = dao.getCountry(uuId)
            countryLiveData.value = country
        }
    }
}