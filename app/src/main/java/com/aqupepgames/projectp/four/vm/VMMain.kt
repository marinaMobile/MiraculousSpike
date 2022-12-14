package com.aqupepgames.projectp.four.vm

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.aqupepgames.projectp.four.MainActivity
import com.aqupepgames.projectp.four.db.BasicDao
import com.aqupepgames.projectp.four.db.DataBasic
import com.aqupepgames.projectp.four.repo.CountryRepo
import com.aqupepgames.projectp.four.repo.DevRepo
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.launch

class ViewMainModel(private val mainRepository: CountryRepo, private val devRepo: DevRepo, private val shP: SharedPreferences, private val application: Application
): ViewModel() {

    private val _advertisingIdClient = MutableLiveData<String>()
    val advertisingIdClient: LiveData<String>
        get() = _advertisingIdClient


    private val _couData = MutableLiveData<String>()
    val couData: LiveData<String>
        get() = _couData

    private val _linka = MutableLiveData<String>()
    val linka: LiveData<String>
        get() = _linka

    private val _appsCh = MutableLiveData<String>()
    val appsCh: LiveData<String>
        get() = _appsCh

    private val _geoC = MutableLiveData<String>()
    val geoC: LiveData<String>
        get() = _geoC

    init {
        viewModelScope.launch {

        }
    }


    private suspend fun getData() {
        if (mainRepository.getDat().isSuccessful) {
            val result = mainRepository.getDat().body()!!
            _couData.postValue(result.countryCode)
        }

    }

    private suspend fun getDataVil() {
        if (devRepo.getDataDev().isSuccessful) {
            val geoC = devRepo.getDataDev().body()?.geo.toString()
            val linka = devRepo.getDataDev().body()?.view.toString()
            val appsCh = devRepo.getDataDev().body()?.appsChecker.toString()

            _linka.postValue(linka)
            _geoC.postValue(geoC)
            _appsCh.postValue(appsCh)

        }
    }


    private suspend fun checkGrek() {
        val check = appsCh.value
        val vilGeo = geoC.value
        val userGeo = couData.value

        val naming = shP.getString("apps", "null")


    }




    private fun getAdvertisingIdClient() {
        val advertisingIdClient = AdvertisingIdClient(application)
        advertisingIdClient.start()
        val idUserAdvertising = advertisingIdClient.info.id ?: "null"
        _advertisingIdClient.postValue(idUserAdvertising)
    }

     fun initAppsFlyerLib(context: Context) {
        AppsFlyerLib.getInstance()
            .init("FuAe4RZRjun4qN3szzKekD", conversionDataListener, application)
        AppsFlyerLib.getInstance().start(context)
    }

    val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString()
            shP.edit().putString("apps", dataGotten).apply()
        }
        override fun onConversionDataFail(p0: String?) {}
        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {}
        override fun onAttributionFailure(p0: String?) {}
    }
}
