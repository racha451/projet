package com.example.projet.data.Single_company_detail


import androidx.lifecycle.LiveData
import com.example.projet.data.api.CompanyDBInterface
import com.example.projet.data.repository.ComapanyDetailsData
import com.example.projet.data.repository.NetworkState
import com.example.projet.data.vo.CompanyDetails
import io.reactivex.disposables.CompositeDisposable

class comapanyDetailRep (private val apiService : CompanyDBInterface) {

    lateinit var comapanyDetailsData: ComapanyDetailsData

    fun fetchSingleCompanyDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<CompanyDetails> {

        comapanyDetailsData = ComapanyDetailsData(apiService,compositeDisposable)
        comapanyDetailsData.fetchMovieDetails(movieId)

        return comapanyDetailsData.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return comapanyDetailsData.networkState
    }



}

