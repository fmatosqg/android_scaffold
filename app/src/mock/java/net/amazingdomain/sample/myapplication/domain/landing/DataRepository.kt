package net.amazingdomain.sample.myapplication.domain.landing

import androidx.annotation.AnyThread
import io.reactivex.Single
import net.amazingdomain.sample.myapplication.domain.landing.api.ApiService
import java.util.concurrent.TimeUnit

class DataRepository(private val apiService: ApiService) : IDataRepository {

    private var size = 5

    @AnyThread
    override fun fetchData(): Single<List<String>> {

        val list = mutableListOf<String>()

        for (i in 0..(size - 1)) {
            list += "Kitty # $i"
        }

        size++

        return Single.just(list as List<String>)
                .delay(200, TimeUnit.MILLISECONDS)


    }

}