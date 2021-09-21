package io.github.regbl.fetchrewardsjsonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.regbl.fetchrewardsjsonlist.data.Item
import io.github.regbl.fetchrewardsjsonlist.data.Repository
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _itemList: MutableLiveData<List<Item>> = liveData {
        val response = repository.getItemList()
        if (response.isSuccessful) {
            response.body()?.let { itemList ->
                emit(
                    itemList.filter { item ->
                        !item.name.isNullOrBlank()
                    }.sortedBy { item ->
                        item.name
                    }.sortedBy { item ->
                        item.listId
                    }
                )
            }
        }
    } as MutableLiveData<List<Item>>

    var itemList: LiveData<List<Item>> = _itemList
}