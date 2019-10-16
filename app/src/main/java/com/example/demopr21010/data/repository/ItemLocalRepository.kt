package com.example.demopr21010.data.repository

import com.example.demopr21010.coroutine.ResultCoroutines
import com.example.demopr21010.data.model.OwnerModel
import com.example.demopr21010.data.source.ItemDataSource

class ItemLocalRepository(private val itemRemoteDataSource: ItemDataSource.Local) :
    ItemDataSource.Local {
    override suspend fun getItems(): ResultCoroutines<List<OwnerModel>> {
        return itemRemoteDataSource.getItems()
    }

    override fun insertOwner(ownerModel: OwnerModel): ResultCoroutines<OwnerModel> {
        return itemRemoteDataSource.insertOwner(ownerModel)
    }
}