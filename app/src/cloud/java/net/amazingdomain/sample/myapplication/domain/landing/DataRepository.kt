package net.amazingdomain.sample.myapplication.domain.landing

import io.reactivex.Single
import net.amazingdomain.sample.myapplication.domain.landing.api.ApiService
import net.amazingdomain.sample.myapplication.domain.landing.model.Album

class DataRepository(private val apiService: ApiService) : IDataRepository {

    override fun fetchData(): Single<List<Album>> {

        return apiService
                .getData()

    }

}


