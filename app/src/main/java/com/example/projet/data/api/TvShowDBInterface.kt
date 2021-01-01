package com.example.projet.data.api

import com.example.projet.data.vo.TvShowDetails
import com.example.projet.data.vo.ListTvSow
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowDBInterface {

    // https://api.themoviedb.org/3/tv/67?api_key=67a80710810611d36586dcc9328b2aa0


    @GET("tv/{id}")
    fun getMovieDetails(@Path("id") id: Int): Single<TvShowDetails>



    @GET("tv/top_rated")
    fun getPopularMovie(@Query("page") page: Int): Single<ListTvSow>
}