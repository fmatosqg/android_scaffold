package net.amazingdomain.sample.myapplication.domain.landing

import io.reactivex.Single

interface IDataRepository {
    fun fetchData(): Single<List<String>>

}