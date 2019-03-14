package net.amazingdomain.sample.myapplication.ui.landing

import android.annotation.SuppressLint
import androidx.annotation.UiThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import net.amazingdomain.sample.myapplication.domain.landing.DataRepository

class LandingViewModel(private val dataRepository: DataRepository) : ViewModel() {

    val isRefreshing = MutableLiveData<Boolean>()
    val listData = MutableLiveData<List<String>>()


    @SuppressLint("CheckResult")
    @UiThread
    fun fetchData() {

        isRefreshing.postValue(true)

        dataRepository.fetchData()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribeBy(
                        onError = { isRefreshing.postValue(false) },
                        onSuccess = {
                            isRefreshing.postValue(false)
                            listData.postValue(it)
                        }
                )

    }

}
