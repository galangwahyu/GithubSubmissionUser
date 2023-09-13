package com.example.githubsubmissionuser.api

import com.example.githubsubmissionuser.data.ResponseDetailUser
import com.example.githubsubmissionuser.data.ResponseUserLists
import com.example.githubsubmissionuser.data.ResponseUsersSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val API_KEY = "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"
    }
    @GET("users")
    @Headers("Authorization: token $API_KEY")
    fun getUsers(): Call<ArrayList<ResponseUserLists>>

    @GET("search/users")
    @Headers("Authorization: token $API_KEY")
    fun getSearchUsers( @Query("q") username: String): Call<ResponseUsersSearch>

    @GET("users/{username}")
    @Headers("Authorization: token $API_KEY")
    fun getDetailUser(@Path("username") username: String) : Call<ResponseDetailUser>

    @GET("users/{username}/followers")
    @Headers("Authorization: token $API_KEY")
    fun getFollowers(@Path("username") username: String) : Call<ArrayList<ResponseUserLists>>

    @GET("users/{username}/following")
    @Headers("Authorization: token $API_KEY")
    fun getFollowings(@Path("username") username: String) : Call<ArrayList<ResponseUserLists>>
}