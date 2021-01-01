package com.example.projet.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.projet.data.repository.NetworkState
import com.example.projet.data.repository.TvShowListRep
import com.example.projet.data.vo.TvShow
import io.reactivex.disposables.CompositeDisposable

class MainActivityViewModel
(private val movieRepository : TvShowListRep) : ViewModel() {


    private val compositeDisposable = CompositeDisposable()

    val  moviePagedList : LiveData<PagedList<TvShow>> by lazy {
        movieRepository.fetchLiveMoviePagedList(compositeDisposable)
    }

    val  networkState : LiveData<NetworkState> by lazy {
        movieRepository.getNetworkState()
    }

    fun listIsEmpty(): Boolean {
        return moviePagedList.value?.isEmpty() ?: true
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}

