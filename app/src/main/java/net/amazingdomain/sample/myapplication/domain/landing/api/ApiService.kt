package net.amazingdomain.sample.myapplication.domain.landing.api

import io.reactivex.Single
import net.amazingdomain.sample.myapplication.domain.landing.model.Album
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/albums/")
    fun getData(): Single<List<Album>>
}

