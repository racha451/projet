package com.example.projet.ViewModel


import com.example.projet.data.repository.NetworkState



import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.projet.data.singletvshowdetail.TvShowDetailRep
import com.example.projet.data.vo.TvShowDetails

import io.reactivex.disposables.CompositeDisposable

class SingleTvShowViewModel (private val tvshowRepository :TvShowDetailRep, movieId: Int)  : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val  tvshowdetails : LiveData<TvShowDetails> by lazy {
        tvshowRepository.fetchSingleTvShow(compositeDisposable,movieId)
    }

    val networkState : LiveData<NetworkState> by lazy {
        tvshowRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }



}