package net.amazingdomain.sample.myapplication.util.di

import net.amazingdomain.sample.myapplication.domain.landing.DataRepository
import net.amazingdomain.sample.myapplication.ui.landing.LandingViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class KoinModules {

    companion object {
        fun getInstance(): KoinModules {
            return KoinModules()
        }
    }

    private constructor()

    val uiModule = module {
        viewModel { LandingViewModel(get()) }
    }

    val domainModule = module {

        factory { DataRepository() }
    }


}