package net.amazingdomain.sample.myapplication.domain.landing

import androidx.annotation.AnyThread
import io.reactivex.Single
import net.amazingdomain.sample.myapplication.domain.landing.api.ApiService
import net.amazingdomain.sample.myapplication.domain.landing.model.Album
import java.util.concurrent.TimeUnit

class DataRepository(private val apiService: ApiService) : IDataRepository {

    private var size = 4

    @AnyThread
    override fun fetchData(): Single<List<Album>> {

        val list = mutableListOf<Album>()

        for (i in 0..(size - 1)) {
            list += Album(niceName = "Kitty #$i",
                    thumbnail = "https://66.media.tumblr.com/5b29224d7cc879593a56b6ee23176882/tumblr_pol0kdxufk1qd9qa2o1_500.png")
        }

        list += Album(niceName = "Kitty #$size",
                thumbnail = "")

        size++

        return Single.just(list as List<Album>)
                .delay(1, TimeUnit.SECONDS)


    }

}