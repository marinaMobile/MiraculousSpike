package com.aqupepgames.projectp.four.inter

import com.aqupepgames.projectp.four.data.CodeData
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("json/?key=ZSSz86ONagSoYRv")
    suspend fun getData(): Response<CodeData>
}