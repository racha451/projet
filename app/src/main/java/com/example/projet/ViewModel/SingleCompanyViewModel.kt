package com.example.projet.ViewModel

import com.example.projet.data.Single_company_detail.comapanyDetailRep
import com.example.projet.data.repository.NetworkState



import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.projet.data.vo.CompanyDetails

import io.reactivex.disposables.CompositeDisposable

class SingleCompanyViewModel (private val companyRepository : comapanyDetailRep, movieId: Int)  : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val  companyDetails : LiveData<CompanyDetails> by lazy {
        companyRepository.fetchSingleCompanyDetails(compositeDisposable,movieId)
    }

    val networkState : LiveData<NetworkState> by lazy {
        companyRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }



}