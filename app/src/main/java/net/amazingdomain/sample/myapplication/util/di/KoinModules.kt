package net.amazingdomain.sample.myapplication.util.di

import com.google.gson.Gson
import net.amazingdomain.sample.myapplication.BuildConfig
import net.amazingdomain.sample.myapplication.domain.landing.DataRepository
import net.amazingdomain.sample.myapplication.domain.landing.api.ApiService
import net.amazingdomain.sample.myapplication.ui.landing.LandingViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class KoinModules {

    companion object {
        fun getInstance(): KoinModules {
            return KoinModules()
        }

    }

    private constructor()

    fun getAllModules(): List<Module> {

        return listOf(uiModule, domainModule, networkModule)
    }


    private val uiModule = module {
        viewModel { LandingViewModel(get()) }
    }

    private val domainModule = module {

        factory { DataRepository(get()) }
    }

    private val networkModule = module {

        factory { Gson() }
        factory { OkHttpClient.Builder().build() }
        factory {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create(get()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(get())
                    .build()

            retrofit.create<ApiService>(ApiService::class.java)
        }


    }

}


