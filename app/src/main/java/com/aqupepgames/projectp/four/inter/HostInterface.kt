package com.aqupepgames.projectp.four.inter

import com.aqupepgames.projectp.four.data.VillainData
import retrofit2.Response
import retrofit2.http.GET

interface HostInterface {
    @GET("stan.json")
    suspend fun getDataDev(): Response<VillainData>
}

