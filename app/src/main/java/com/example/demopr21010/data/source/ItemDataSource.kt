package com.example.demopr21010.data.source

import com.example.demopr21010.coroutine.ResultCoroutines
import com.example.demopr21010.data.api.response.ItemResponse
import com.example.demopr21010.data.model.OwnerModel

interface ItemDataSource {
    interface Remote{
        suspend fun getItems(): ResultCoroutines<ItemResponse>
    }
    interface Local{
        suspend fun getItems(): ResultCoroutines<List<OwnerModel>>
        fun insertOwner(ownerModel: OwnerModel):ResultCoroutines<OwnerModel>
    }
}