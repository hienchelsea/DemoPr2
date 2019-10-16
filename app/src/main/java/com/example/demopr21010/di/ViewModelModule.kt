package com.example.demopr21010.di

import com.example.demopr21010.ui.dataRoom.DataRoomViewModel
import com.example.demopr21010.ui.main.MainViewModel
import com.example.demopr21010.ui.retrofit.RetrofitViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(repository = get(named("RepositoryRemote"))) }
    viewModel {
        RetrofitViewModel(
            repositoryRemote = get(named("RepositoryRemote")),
            repositoryLocal = get(named("RepositoryLocal"))
        )
    }
    viewModel { DataRoomViewModel(repositoryLocal = get(named("RepositoryLocal"))) }
}