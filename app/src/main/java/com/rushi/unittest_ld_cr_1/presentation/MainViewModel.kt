package com.rushi.unittest_ld_cr_1.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.rushi.unittest_ld_cr_1.data.utils.Resource
import com.rushi.unittest_ld_cr_1.domain.model.PostItem
import com.rushi.unittest_ld_cr_1.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: MainRepository) : ViewModel(){

    private val _postsLivedata = MutableLiveData<List<PostItem>>()
    val postsLiveData : LiveData<List<PostItem>> = _postsLivedata

    private val channel = Channel<String>()
    val channelLiveData = channel.receiveAsFlow().asLiveData()

    init {
        getPosts()
    }

    fun getPosts(){
        viewModelScope.launch {
            val res = repository.getPosts()
            when(res){
                is Resource.Error -> channel.send(res.message ?: "UE")
                is Resource.Loading -> TODO()
                is Resource.Success -> _postsLivedata.value = res.data1 ?: emptyList()
            }
        }
    }
}