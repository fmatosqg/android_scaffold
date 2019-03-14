package net.amazingdomain.sample.myapplication.domain.landing.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/users/{user}")
    fun getData(@Path("user") user: String): Single<User>
}

data class User(val id: Int, val url: String, val login: String)