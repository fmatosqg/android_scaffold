package net.amazingdomain.sample.myapplication.util.di

import net.amazingdomain.sample.myapplication.domain.landing.DataRepository
import net.amazingdomain.sample.myapplication.ui.landing.LandingViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class KoinSetup {

    companion object {
        fun getInstance(): KoinSetup {
            return KoinSetup()
        }
    }

    private constructor()

    val uiModule = module {
        viewModel { LandingViewModel() }
    }

    val domainModule = module {

        single { DataRepository() }
    }


}