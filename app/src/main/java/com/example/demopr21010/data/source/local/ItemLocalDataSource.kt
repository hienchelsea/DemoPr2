package com.example.demopr21010.data.source.local

import com.example.demopr21010.coroutine.HandersApiResult
import com.example.demopr21010.coroutine.ResultCoroutines
import com.example.demopr21010.data.db.AppDatabase
import com.example.demopr21010.data.model.OwnerModel
import com.example.demopr21010.data.source.ItemDataSource

class ItemLocalDataSource(private val appDatabase: AppDatabase) : ItemDataSource.Local,
    HandersApiResult() {
    override suspend fun getItems(): ResultCoroutines<List<OwnerModel>> = try {
        ResultCoroutines.Success(appDatabase.userDao().getAllUser())
    } catch (e: Exception) {
        ResultCoroutines.Error(e)
    }

    override fun insertOwner(ownerModel: OwnerModel): ResultCoroutines<OwnerModel> = try {
        appDatabase.userDao().insert(ownerModel)
        ResultCoroutines.Success(ownerModel)
    } catch (e: Exception) {
        ResultCoroutines.Error(e)
    }
}