package com.example.multirecyclerview.repository

import com.example.multirecyclerview.retrofit.Client
import com.example.sleep2.tools.DataClasses
import retrofit2.Response

class MyRepository() {
    suspend fun getJokeRepository():Response<List<DataClasses.Joke>>{
        return Client.getJokeInstance().getJoke()
    }

    suspend fun getBookRepos():Response<DataClasses.BookModel>{
        return Client.getBookInstance().getBooks("Mass Effect", 10, "AIzaSyDNpo36bF-hhoGzBDEyLMqIllgfuLmg00I")
    }
}