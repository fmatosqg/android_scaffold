package net.amazingdomain.sample.myapplication.ui.landing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.amazingdomain.sample.myapplication.domain.landing.DataRepository

class LandingViewModel(private val dataRepository: DataRepository) : ViewModel() {


    val kittyName = MutableLiveData<String>()

    val listData = MutableLiveData<List<String>>()


    fun fetchData() {
        kittyName.postValue("name kitty")
        listData.postValue(dataRepository.fetchData())
    }

}
