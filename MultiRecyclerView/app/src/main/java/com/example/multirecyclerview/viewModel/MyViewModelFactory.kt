package com.example.multirecyclerview.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.multirecyclerview.repository.MyRepository
import java.lang.IllegalArgumentException

class MyViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MyRepository()) as T
        }
        throw IllegalArgumentException("Unknown Class from Factory")
    }
}