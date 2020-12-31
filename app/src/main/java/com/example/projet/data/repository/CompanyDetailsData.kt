package com.example.projet.data.repository



import android.net.Network
import android.util.Log


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projet.data.api.CompanyDBInterface

import com.example.projet.data.vo.CompanyDetails
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ComapanyDetailsData (private val apiService : CompanyDBInterface, private val compositeDisposable: CompositeDisposable) {

    private val _networkState  = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState                   //with this get, no need to implement get function to get networkSate

    private val _downloadedMovieDetailsResponse =  MutableLiveData<CompanyDetails>()
    val downloadedMovieResponse: LiveData<CompanyDetails>
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
                                        it.message?.let { it1 -> Log.e("ComapanyDetailsData", it1) }
                                    }
                            )
            )

        }

        catch (e: Exception){
            e.message?.let { Log.e("ComapanyDetailsData", it) }
        }


    }
}