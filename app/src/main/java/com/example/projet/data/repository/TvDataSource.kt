package com.example.projet.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.projet.data.api.FIRST_PAGE
import com.example.projet.data.api.TvShowDBInterface
import com.example.projet.data.vo.TvShow
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class TvDataSource (private val apiService : TvShowDBInterface, private val compositeDisposable: CompositeDisposable)
    : PageKeyedDataSource<Int, TvShow>(){

    private var page = FIRST_PAGE

    val networkState: MutableLiveData<NetworkState> = MutableLiveData()


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, TvShow>) {

        networkState.postValue(NetworkState.LOADING)

        compositeDisposable.add(
                apiService.getPopularMovie(page)
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                {
                                    callback.onResult(it.tvShowList, null, page+1)
                                    networkState.postValue(NetworkState.LOADED)
                                },
                                {
                                    networkState.postValue(NetworkState.ERROR)
                                    it.message?.let { it1 -> Log.e("MovieDataSource", it1) }
                                }
                        )
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, TvShow>) {
        networkState.postValue(NetworkState.LOADING)

        compositeDisposable.add(
                apiService.getPopularMovie(params.key)
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                {
                                    if(it.total_pages >= params.key) {
                                        callback.onResult(it.tvShowList, params.key+1)
                                        networkState.postValue(NetworkState.LOADED)
                                    }
                                    else{
                                    }
                                },
                                {
                                    networkState.postValue(NetworkState.ERROR)
                                    it.message?.let { it1 -> Log.e("MovieDataSource", it1) }
                                }
                        )
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, TvShow>) {

    }
}