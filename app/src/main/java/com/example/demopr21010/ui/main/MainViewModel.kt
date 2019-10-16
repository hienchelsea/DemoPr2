package com.example.demopr21010.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demopr21010.coroutine.ResultCoroutines
import com.example.demopr21010.data.model.ItemModel
import com.example.demopr21010.data.repository.ItemRemoteRepository
import com.example.demopr21010.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: ItemRemoteRepository
):BaseViewModel() {
}