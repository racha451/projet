package com.example.projet.data.api

import com.example.projet.data.vo.CompanyDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CompanyDBInterface {

    // https://api.themoviedb.org/3/company/67?api_key=67a80710810611d36586dcc9328b2aa0


    @GET("company/{company_id}")
    fun getMovieDetails(@Path("company_id") id: Int): Single<CompanyDetails>
}