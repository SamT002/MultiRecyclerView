package com.example.sleep2.tools

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.multirecyclerview.databinding.ItemBinding
import com.example.multirecyclerview.databinding.SecondItemBinding
import com.squareup.picasso.Picasso


sealed class ViewHoldersCollection(binding:ViewBinding):RecyclerView.ViewHolder(binding.root){

    class FirstViewHolder(private val binding: ItemBinding) : ViewHoldersCollection(binding) {

        fun bind(item: DataClasses.Item) {

            if (item.volumeInfo.imageLinks.thumbnail != null) {
                Picasso.with(binding.image.context)
                    .load(item.volumeInfo.imageLinks.thumbnail)
                    .into(binding.image)
            }

            binding.title.text = item.volumeInfo.title

        }

    }

    class SecondViewHolder(private val binding: SecondItemBinding) : ViewHoldersCollection(binding){
        fun bind(joke: DataClasses.Joke){
            binding.punchline.text = joke.punchline
            binding.setup.text = joke.setup
        }
    }

}
