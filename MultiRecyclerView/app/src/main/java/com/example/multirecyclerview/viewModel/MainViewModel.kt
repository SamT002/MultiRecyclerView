package com.example.multirecyclerview.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.multirecyclerview.repository.MyRepository
import com.example.sleep2.tools.DataClasses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MyRepository) : ViewModel() {
    val data = MutableLiveData<List<DataClasses>>()
    val secondData = MutableLiveData<DataClasses.BookModel>()

    init {
        getJoke()
        getBook()
    }

    private fun getJoke() {
        viewModelScope.launch {
            val response = repository.getJokeRepository()
            if (response.isSuccessful) data.postValue(response.body() as List<DataClasses>)
        }
    }

    private fun getBook(){
        viewModelScope.launch {
            val response = repository.getBookRepos()
            if (response.isSuccessful) secondData.postValue(response.body())
        }
    }




}