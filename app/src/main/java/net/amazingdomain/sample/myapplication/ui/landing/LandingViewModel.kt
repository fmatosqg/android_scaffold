package net.amazingdomain.sample.myapplication.ui.landing

import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.UiThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import net.amazingdomain.sample.myapplication.domain.landing.DataRepository
import net.amazingdomain.sample.myapplication.ui.landing.model.AlbumUiModel
import net.amazingdomain.sample.myapplication.ui.landing.model.convertToUiModel

class LandingViewModel(private val dataRepository: DataRepository) : ViewModel() {

    val isRefreshing = MutableLiveData<Boolean>()
    val listData = MutableLiveData<List<AlbumUiModel>>()


    @SuppressLint("CheckResult")
    @UiThread
    fun fetchData() {

        isRefreshing.postValue(true)

        dataRepository.fetchData()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .flattenAsFlowable { it }
                .map { it.convertToUiModel() }
                .toList()
                .subscribeBy(
                        onError = {
                            Log.w("LandingViewModel", it)
                            isRefreshing.postValue(false)
                        },
                        onSuccess = {
                            isRefreshing.postValue(false)
                            listData.postValue(it)
                        }
                )

    }

}
