package com.example.demopr21010.data.repository

import com.example.demopr21010.coroutine.ResultCoroutines
import com.example.demopr21010.data.api.response.ItemResponse
import com.example.demopr21010.data.source.ItemDataSource

class ItemRemoteRepository(
    private val itemRemoteDataSource: ItemDataSource.Remote
) : ItemDataSource.Remote {
    override suspend fun getItems(): ResultCoroutines<ItemResponse> {
        return itemRemoteDataSource.getItems()
    }
}