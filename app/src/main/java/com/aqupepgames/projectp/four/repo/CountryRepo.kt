package com.aqupepgames.projectp.four.repo

import com.aqupepgames.projectp.four.inter.ApiInterface

class CountryRepo(private val countryApi: ApiInterface) {
    suspend fun getDat() = countryApi.getData()
}