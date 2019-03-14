package net.amazingdomain.sample.myapplication.ui.landing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LandingViewModel : ViewModel() {


    val kittyName = MutableLiveData<String>()

    init {
        fetchData()
    }

    private fun fetchData() {
        kittyName.postValue("name kitty")
    }


}
