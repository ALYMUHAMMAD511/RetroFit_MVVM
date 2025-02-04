package com.example.retrofitmvvm.data;

import com.example.retrofitmvvm.models.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET(PostsClient.RESOURCE)
    public Call<List<PostModel>> getPosts();
}
