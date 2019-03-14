package net.amazingdomain.sample.myapplication.domain.landing

import io.reactivex.Single
import net.amazingdomain.sample.myapplication.domain.landing.api.ApiService

class DataRepository(private val apiService: ApiService) : IDataRepository {

    override fun fetchData(): Single<List<String>> {

        return apiService
                .getData("fmatosqg")
                .map { listOf(it.login, it.url) }
    }

}