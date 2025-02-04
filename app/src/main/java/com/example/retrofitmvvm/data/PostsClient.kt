package com.example.retrofitmvvm.data

import com.example.retrofitmvvm.models.PostModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostsClient {
    const val RESOURCE = "posts"
    private const val BASE_URL = "http://jsonplaceholder.typicode.com/"
    private val postInterface: PostInterface
    val instance: PostsClient by lazy { PostsClient }


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        postInterface = retrofit.create(PostInterface::class.java)
    }

    fun getPosts(): Call<List<PostModel>> {
        return postInterface.getPosts()
    }
}