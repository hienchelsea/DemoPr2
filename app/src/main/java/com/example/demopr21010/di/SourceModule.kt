package com.example.demopr21010.di

import com.example.demopr21010.data.api.APIFactory
import com.example.demopr21010.data.db.AppDatabase
import com.example.demopr21010.data.repository.ItemLocalRepository
import com.example.demopr21010.data.repository.ItemRemoteRepository
import com.example.demopr21010.data.source.local.ItemLocalDataSource
import com.example.demopr21010.data.source.remote.ItemRemoteDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val sourceModule = module {

    single(named("Api")) {
        APIFactory.api
    }
    single(named("AppDatabase")) {
        AppDatabase.getInstance(androidContext())
    }
    single(named("SourceRemote")) {
        ItemRemoteDataSource(itemApi = get(named("Api")))
    }
    single(named("SourceLocal")) {
        ItemLocalDataSource(appDatabase = get(named("AppDatabase")))
    }
    single(named("RepositoryRemote")) {
        ItemRemoteRepository(itemRemoteDataSource = get(named("SourceRemote")))
    }
    single(named("RepositoryLocal")) {
        ItemLocalRepository(itemRemoteDataSource = get(named("SourceLocal")))
    }

}