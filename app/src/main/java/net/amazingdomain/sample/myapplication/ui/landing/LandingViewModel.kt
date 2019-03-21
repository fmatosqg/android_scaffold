package net.amazingdomain.sample.myapplication.ui.landing

import android.annotation.SuppressLint
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import net.amazingdomain.sample.myapplication.domain.landing.DataRepository
import net.amazingdomain.sample.myapplication.ui.landing.model.AlbumUiModel
import net.amazingdomain.sample.myapplication.ui.landing.model.convertToUiModel
import timber.log.Timber

class LandingViewModel(val dataRepository: DataRepository) : ViewModel() {

    val heroUrl = MutableLiveData<String>()

    val isRefreshing = MutableLiveData<Boolean>()
    val isPlaceholderVisible = MutableLiveData<Int>() // View.GONE or View.VISIBLE
    val isRecyclerViewVisible = MutableLiveData<Int>() // View.GONE or View.VISIBLE
    val listData = MutableLiveData<List<AlbumUiModel>>()


    init {
        setChildrenVisibility(true)
        fetchData()
    }

    @SuppressLint("CheckResult")
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
                            Timber.w(it)
                            isRefreshing.postValue(false)
                            setChildrenVisibility(isPlaceholderVisible = true)
                        },
                        onSuccess = {
                            isRefreshing.postValue(false)
                            listData.postValue(it)

                            if ( !it.isEmpty() ) {
                                heroUrl.postValue(it[0].thumbnailUrl)
                            }
                            setChildrenVisibility(isPlaceholderVisible = it.isEmpty())
                        }
                )
    }

    private fun setChildrenVisibility(isPlaceholderVisible: Boolean) {

        val placeholderVisibility = if (isPlaceholderVisible) View.VISIBLE else View.GONE
        val recyclerViewVisibility = if (!isPlaceholderVisible) View.VISIBLE else View.GONE

        this.isPlaceholderVisible.postValue(placeholderVisibility)
        isRecyclerViewVisible.postValue(recyclerViewVisibility)
    }

}
