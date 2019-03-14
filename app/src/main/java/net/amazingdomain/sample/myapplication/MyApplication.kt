package net.amazingdomain.sample.myapplication

import android.app.Application
import android.os.Build
import android.os.StrictMode
import net.amazingdomain.sample.myapplication.util.di.KoinSetup
import org.koin.android.ext.android.startKoin


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        with(KoinSetup.getInstance()) {
            startKoin(this@MyApplication, listOf(uiModule, domainModule))
        }

        if (BuildConfig.DEBUG) {
            configureStrictMode()
        }
    }

    private fun configureStrictMode() {


        var threadPolicyBuilder = StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
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

