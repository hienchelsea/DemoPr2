package com.example.demopr21010.ui.retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demopr21010.coroutine.ResultCoroutines
import com.example.demopr21010.data.model.OwnerModel
import com.example.demopr21010.data.repository.ItemLocalRepository
import com.example.demopr21010.data.repository.ItemRemoteRepository
import com.example.demopr21010.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class RetrofitViewModel(
    private val repositoryRemote: ItemRemoteRepository,
    private val repositoryLocal: ItemLocalRepository
) : BaseViewModel() {

    private val _owner = MutableLiveData<String>()
    val owner: LiveData<String>
        get() = _owner

    private val _items = MutableLiveData<List<OwnerModel>>()
    val item: LiveData<List<OwnerModel>>
        get() = _items

    init {
        getItem()
    }

    fun insert(ownerModel: OwnerModel) = launch {
        when (val chapterResponse = repositoryLocal.insertOwner(ownerModel)) {
            is ResultCoroutines.Success -> {
                _owner.postValue("Them thanh cong")
            }
            is ResultCoroutines.Error -> {
                _owner.postValue("Them hhong thanh cong")
            }
        }

    }

    private fun getItem() = launch {

        when (val chapterResponse = repositoryRemote.getItems()) {
            is ResultCoroutines.Success -> {
                val owners = mutableListOf<OwnerModel>()
                for (element in chapterResponse.data.items) {
                    val owner: OwnerModel = element.owner
                    owners.add(owner)
                }
                _items.postValue(owners)
            }
            is ResultCoroutines.Error -> {
                Log.d("Hien", "${chapterResponse.exception}")
            }
        }
    }
}
