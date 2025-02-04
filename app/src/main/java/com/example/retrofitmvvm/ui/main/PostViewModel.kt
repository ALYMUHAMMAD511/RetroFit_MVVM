package com.example.retrofitmvvm.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmvvm.data.PostsClient
import com.example.retrofitmvvm.models.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {
    val postsMutableLiveData = MutableLiveData<List<PostModel>>()

    fun getPosts() {
        PostsClient.instance.getPosts().enqueue(object : Callback<List<PostModel>>{
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                postsMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<PostModel>>, e: Throwable) {
                Log.d("MAIN_ACTIVITY", e.toString())
            }
        })
    }
}