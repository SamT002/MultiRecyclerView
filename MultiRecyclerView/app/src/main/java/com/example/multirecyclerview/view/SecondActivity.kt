package com.example.multirecyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multirecyclerview.databinding.ActivitySecondBinding
import com.example.multirecyclerview.view.adapter.ViewHolderAdapter
import com.example.multirecyclerview.viewModel.MainViewModel
import com.example.multirecyclerview.viewModel.MyViewModelFactory
import com.example.sleep2.tools.DataClasses

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val myAdapter by lazy { ViewHolderAdapter() }
    private val viewModel by lazy { ViewModelProvider(this, MyViewModelFactory()).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecycler()

        viewModel.secondData.observe(this, Observer {
            myAdapter.setList(null, it.items)
        })
    }

    private fun setUpRecycler() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@SecondActivity)
            adapter = myAdapter
        }
    }


}