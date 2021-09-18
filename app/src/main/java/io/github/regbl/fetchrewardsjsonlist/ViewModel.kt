package io.github.regbl.fetchrewardsjsonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.regbl.fetchrewardsjsonlist.data.Item
import io.github.regbl.fetchrewardsjsonlist.data.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _itemList = MutableLiveData<List<Item>>()
    var itemList: LiveData<List<Item>> = _itemList

    init {
        viewModelScope.launch {
            val response = repository.getItemList()
            if (response.isSuccessful) {
                _itemList.postValue(response.body())
            }
        }
    }
}