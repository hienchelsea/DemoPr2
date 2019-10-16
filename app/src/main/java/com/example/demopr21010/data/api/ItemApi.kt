package com.example.demopr21010.data.api

import com.example.demopr21010.data.api.response.ItemResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ItemApi {
    @GET("/2.2/answers?order=desc&sort=activity&site=stackoverflow")
    fun itemAsync(): Deferred<Response<ItemResponse>>
}