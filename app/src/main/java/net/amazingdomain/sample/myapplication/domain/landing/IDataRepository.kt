package net.amazingdomain.sample.myapplication.domain.landing

import io.reactivex.Single
import net.amazingdomain.sample.myapplication.domain.landing.model.Album

interface IDataRepository {
    fun fetchData(): Single<List<Album>>

}