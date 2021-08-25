package com.example.multirecyclerview.retrofit

import com.example.sleep2.tools.DataClasses
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Request {

    @GET("random_ten/")
    suspend fun getJoke(): Response<List<DataClasses.Joke>>

    @GET("volumes")
    suspend fun getBooks(@Query("q") q:String, @Query("maxResults") maxResults:Int, @Query("key") key:String): Response<DataClasses.BookModel>


}