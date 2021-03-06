package net.amazingdomain.sample.myapplication

import android.app.Application
import android.os.Build
import android.os.StrictMode
import net.amazingdomain.sample.myapplication.util.di.KoinModules
import org.koin.android.ext.android.startKoin
import org.koin.android.logger.AndroidLogger
import org.koin.log.EmptyLogger
import timber.log.Timber


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            android.os.Handler()
                    .post { configureStrictMode() }

            Timber.plant(Timber.DebugTree())
        }

        val koinLogger = if (BuildConfig.DEBUG) {
            AndroidLogger()
        } else {
            EmptyLogger()
        }

        startKoin(androidContext = this,
                modules = KoinModules.getInstance().getAllModules(),
                logger = koinLogger)

    }

    private fun configureStrictMode() {


        var threadPolicyBuilder = StrictMode.ThreadPolicy.Builder()
//                .detectDiskReads() // too much unnecessary noise from libs
                .detectDiskWrites()
                .detectNetwork()
                .detectAll()
                .detectCustomSlowCalls()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            threadPolicyBuilder.detectResourceMismatches()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            threadPolicyBuilder.detectUnbufferedIo()
        }

        val threadPolicy = threadPolicyBuilder
                .penaltyFlashScreen()
                .build()

        StrictMode.setThreadPolicy(threadPolicy)


        val vmPolicyBuilder = StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .detectActivityLeaks()
                .detectLeakedRegistrationObjects()

        val vmPolicy = vmPolicyBuilder.penaltyLog()
                .penaltyLog()
                .build()

        StrictMode.setVmPolicy(vmPolicy)


    }


}

