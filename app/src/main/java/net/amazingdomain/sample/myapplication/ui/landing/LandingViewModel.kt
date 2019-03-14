package net.amazingdomain.sample.myapplication.ui.landing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LandingViewModel : ViewModel() {


    val kittyName = MutableLiveData<String>()

    val listData = MutableLiveData<List<String>>()

    init {
        fetchData()
    }

    private fun fetchData() {
        kittyName.postValue("name kitty")
        listData.postValue(listOf("a", "b"))
    }

}
