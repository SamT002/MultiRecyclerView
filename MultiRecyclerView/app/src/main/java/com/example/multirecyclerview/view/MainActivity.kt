package com.example.multirecyclerview.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multirecyclerview.databinding.ActivityMainBinding
import com.example.multirecyclerview.view.adapter.ViewHolderAdapter
import com.example.multirecyclerview.viewModel.MainViewModel
import com.example.multirecyclerview.viewModel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myAdapter by lazy {ViewHolderAdapter()}
    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecycler()

        viewModel = ViewModelProvider(this, MyViewModelFactory()).get(MainViewModel::class.java)

        viewModel.data.observe(this, Observer {
            myAdapter.setList(it, null)
        } )

        binding.button.setOnClickListener {
            Intent(this, SecondActivity::class.java).apply {
                startActivity(this)
            }
        }


    }

    private fun setUpRecycler() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }
    }
}