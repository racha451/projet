package com.example.projet.data.repository


import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

import com.example.projet.data.api.TvShowDBInterface
import com.example.projet.data.vo.TvShow

import io.reactivex.disposables.CompositeDisposable

class TvDataSourceFact (private val apiService :TvShowDBInterface, private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, TvShow>() {

    val moviesLiveDataSource =  MutableLiveData<ControlPages>()

    override fun create(): DataSource<Int, TvShow> {
        val movieDataSource = ControlPages(apiService,compositeDisposable)

        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}