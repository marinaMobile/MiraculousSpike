package com.aqupepgames.projectp

import android.app.Application
import com.aqupepgames.projectp.four.di.appModule
import com.aqupepgames.projectp.four.di.viewModelModule
import com.onesignal.OneSignal
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AppClass :Application(){

    companion object {
        const val ONESIGNAL_APP_ID = "b07d9aea-db80-44e6-a58a-43214193229f"
    }

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(this@AppClass)
            modules(listOf(
                viewModelModule, appModule
            ))
        }

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }


}