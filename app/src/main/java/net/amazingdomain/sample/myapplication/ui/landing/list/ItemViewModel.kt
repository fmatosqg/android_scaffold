package net.amazingdomain.sample.myapplication.ui.landing.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {

    val header = MutableLiveData<String>()

    val name = MutableLiveData<String>()
    val caption = MutableLiveData<String>()
    val captionBold = MutableLiveData<String>()


    init {
        header.postValue("Hello Header")
        caption.postValue("Hello Caption")
        captionBold.postValue("Hello Caption Bold")
    }

    fun setData(name: String) {
        this.name.postValue(name)

    }

}