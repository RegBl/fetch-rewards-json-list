package io.github.regbl.fetchrewardsjsonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.regbl.fetchrewardsjsonlist.data.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    repository: Repository
) : ViewModel() {
    private val _rawJson = MutableLiveData<String>()
    var rawJson: LiveData<String> = _rawJson

    init {
        viewModelScope.launch {
            rawJson = repository.getItemList()
        }
    }
}