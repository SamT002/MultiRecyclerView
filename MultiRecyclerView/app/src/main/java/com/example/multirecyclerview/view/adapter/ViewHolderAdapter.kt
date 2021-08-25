package com.example.multirecyclerview.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multirecyclerview.R
import com.example.multirecyclerview.databinding.ItemBinding
import com.example.multirecyclerview.databinding.SecondItemBinding
import com.example.sleep2.tools.DataClasses
import com.example.sleep2.tools.ViewHoldersCollection

class ViewHolderAdapter : RecyclerView.Adapter<ViewHoldersCollection>() {

    private var items = mutableListOf<DataClasses>()
    private lateinit var context: Context

    fun setList(list: List<DataClasses>?, secondList: List<DataClasses>? ){
        if (list != null) {
            items = list as MutableList<DataClasses>
        }
        else if (secondList != null){
            items = secondList as MutableList<DataClasses>
        }
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldersCollection {
        context = parent.context
        return when (viewType) {
            R.layout.item -> ViewHoldersCollection.FirstViewHolder(
                ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            R.layout.second_item -> ViewHoldersCollection.SecondViewHolder(
                SecondItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            else -> throw IllegalArgumentException("Invalid Type from adapter")
        }
    }

    override fun onBindViewHolder(holder: ViewHoldersCollection, position: Int) {
        when(holder){
            is ViewHoldersCollection.FirstViewHolder -> {
                holder.bind(items[position] as DataClasses.Item)
            }
            is ViewHoldersCollection.SecondViewHolder -> {
                holder.bind(items[position] as DataClasses.Joke)

            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is DataClasses.Joke -> R.layout.second_item
            is DataClasses.Item -> R.layout.item
            else -> super.getItemViewType(position)
        }


//        return super.getItemViewType(position)
    }
}