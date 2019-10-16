package com.example.demopr21010.data.source.remote

import com.example.demopr21010.coroutine.HandersApiResult
import com.example.demopr21010.coroutine.ResultCoroutines
import com.example.demopr21010.data.api.ItemApi
import com.example.demopr21010.data.api.response.ItemResponse
import com.example.demopr21010.data.source.ItemDataSource

class ItemRemoteDataSource(private val itemApi: ItemApi) : ItemDataSource.Remote,
    HandersApiResult() {
    override suspend fun getItems(): ResultCoroutines<ItemResponse> = safeApiResult(
        call = { itemApi.itemAsync().await() },
        errorMessage = "Error Fetching"
    )
}