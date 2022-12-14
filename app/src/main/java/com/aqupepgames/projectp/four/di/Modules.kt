package com.aqupepgames.projectp.four.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.aqupepgames.projectp.R
import com.aqupepgames.projectp.four.db.MainDatabase
import com.aqupepgames.projectp.four.inter.ApiInterface
import com.aqupepgames.projectp.four.inter.HostInterface
import com.aqupepgames.projectp.four.repo.CountryRepo
import com.aqupepgames.projectp.four.repo.DevRepo
import com.aqupepgames.projectp.four.vm.ViewMainModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.android.compat.ScopeCompat.viewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single  <HostInterface> (named("HostInter")){
        get<Retrofit>(named("RetroDev"))
            .create(HostInterface::class.java)
    }

    single <ApiInterface> (named("ApiInter")) {
        get<Retrofit>(named("RetroCountry"))
            .create(ApiInterface::class.java)
    }
    single<Retrofit>(named("RetroCountry")) {
        Retrofit.Builder()
            .baseUrl("http://pro.ip-api.com/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }
    single <Retrofit>(named("RetroDev")){
        Retrofit.Builder()
            .baseUrl("http://miraculousspike.live/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory (named("CountryRep")) {
        CountryRepo(get(named("ApiInter")))
    }

    factory  (named("DevRep")){
        DevRepo(get(named("HostInter")))
    }
    single{
        provideGson()
    }
    single (named("SharedPreferences")) {
        provideSharedPref(androidApplication())
    }

    single(named("DataBase")) {
        Room.databaseBuilder(
            androidApplication(),
            MainDatabase::class.java,
            "BasicDataBase"
        ).build()
    }

    factory (named("BaseDao")){
        get<MainDatabase>(named("DataBase")).basicDao()
    }

}

val viewModelModule = module {
    viewModel {
        ViewMainModel(get(named("CountryRep")), get(named("DevRep")), get(named("SharedPreferences")), get())
    }
}

fun provideGson(): Gson {
    return GsonBuilder().create()
}

fun provideSharedPref(app: Application): SharedPreferences {
    return app.applicationContext.getSharedPreferences(
        "SHARED_PREF",
        Context.MODE_PRIVATE
    )
}