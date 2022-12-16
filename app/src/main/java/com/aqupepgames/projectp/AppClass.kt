package com.aqupepgames.projectp

import android.app.Application
import android.content.Context
import android.util.Log
import com.aqupepgames.projectp.four.di.appModule
import com.aqupepgames.projectp.four.di.viewModelModule
import com.aqupepgames.projectp.four.utils.Constant
import com.aqupepgames.projectp.four.utils.Constant.ONESIGNAL_APP_ID
import com.aqupepgames.projectp.four.utils.Constant.myId
import com.aqupepgames.projectp.four.utils.Constant.myTrId
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.qonversion.android.sdk.QonversionConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import java.util.*
import com.qonversion.android.sdk.Qonversion



class AppClass :Application(){


    override fun onCreate() {

        super.onCreate()
        val shP = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val settings = getSharedPreferences("PREFS_NAME", 0)

        val trackerParams = MyTracker.getTrackerParams()
        val trackerConfig = MyTracker.getTrackerConfig()
        val instID = MyTracker.getInstanceId(this)
        trackerConfig.isTrackingLaunchEnabled = true
        val IDIN = UUID.randomUUID().toString()

        if (settings.getBoolean("my_first_time", true)) {
            trackerParams.setCustomUserId(IDIN)
            shP.edit().putString(myId, IDIN).apply()
            shP.edit().putString(Constant.instId, instID).apply()
            settings.edit().putBoolean("my_first_time", false).apply()
        } else {
            val shIDIN = shP.getString(myId, IDIN)
            trackerParams.setCustomUserId(shIDIN)
        }
        MyTracker.initTracker(myTrId, this)

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


        Qonversion.setDebugMode()
        Qonversion.launch(this, "pdrBIx6s7ZqTvDobWUFqTx3YONn97_tv", false)
    }




}