package com.example.projet.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.DataSource

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.projet.data.api.POST_PER_PAGE
import com.example.projet.data.api.TvShowDBInterface
import com.example.projet.data.vo.TvShow
import io.reactivex.disposables.CompositeDisposable



    class TvShowListRep (private val apiService : TvShowDBInterface) {

        lateinit var moviePagedList: LiveData<PagedList<TvShow>>
        lateinit var moviesDataSourceFactory: TvDataSourceFact

        fun fetchLiveMoviePagedList (compositeDisposable: CompositeDisposable) : LiveData<PagedList<TvShow>> {
            moviesDataSourceFactory = TvDataSourceFact(apiService, compositeDisposable)

            val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(POST_PER_PAGE)
                    .build()

            moviePagedList = LivePagedListBuilder(moviesDataSourceFactory, config).build()

            return moviePagedList
        }
        fun getNetworkState(): LiveData<NetworkState> {
            return Transformations.map<TvDataSource, NetworkState>(
                    moviesDataSourceFactory.moviesLiveDataSource, TvDataSource::networkState )
        }

    }



