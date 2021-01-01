package com.example.projet.data.repository



import android.util.Log


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projet.data.api.TvShowDBInterface
import com.example.projet.data.vo.TvShowDetails

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TvShowDetailsData (private val apiService : TvShowDBInterface, private val compositeDisposable: CompositeDisposable) {

    private val _networkState  = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState                   //with this get, no need to implement get function to get networkSate

    private val _downloadedMovieDetailsResponse =  MutableLiveData<TvShowDetails>()
    val downloadedMovieResponse: LiveData<TvShowDetails>
        get() = _downloadedMovieDetailsResponse

    fun fetchMovieDetails(movieId: Int) {

        _networkState.postValue(NetworkState.LOADING)


        try {
            compositeDisposable.add(
                    apiService.getMovieDetails(movieId)
                            .subscribeOn(Schedulers.io())
                            .subscribe(
                                    {
                                        _downloadedMovieDetailsResponse.postValue(it)
                                        _networkState.postValue(NetworkState.LOADED)
                                    },
                                    {
                                        _networkState.postValue(NetworkState.ERROR)
                                        it.message?.let { it1 -> Log.e("TvShowDetailsData", it1) }
                                    }
                            )
            )

        }

        catch (e: Exception){
            e.message?.let { Log.e("TvShowDetailsData", it) }
        }


    }
}