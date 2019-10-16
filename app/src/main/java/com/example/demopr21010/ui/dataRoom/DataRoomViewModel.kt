package com.example.demopr21010.ui.dataRoom

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demopr21010.coroutine.ResultCoroutines
import com.example.demopr21010.data.model.OwnerModel
import com.example.demopr21010.data.repository.ItemLocalRepository
import com.example.demopr21010.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class DataRoomViewModel(private val repositoryLocal: ItemLocalRepository) : BaseViewModel() {
    private val _items = MutableLiveData<List<OwnerModel>>()
    val item: LiveData<List<OwnerModel>>
        get() = _items

    init {
        getItem()
    }

    private fun getItem() = launch {

        when (val chapterResponse = repositoryLocal.getItems()) {
            is ResultCoroutines.Success -> {
                _items.postValue(chapterResponse.data)
            }
            is ResultCoroutines.Error -> {
                Log.d("Hien", "${chapterResponse.exception}")
            }
        }
    }
}
