package com.example.projet.data.singletvshowdetail




import androidx.lifecycle.LiveData
import com.example.projet.data.api.TvShowDBInterface
import com.example.projet.data.repository.NetworkState
import com.example.projet.data.repository.TvShowDetailsData
import com.example.projet.data.vo.TvShowDetails

import io.reactivex.disposables.CompositeDisposable

class TvShowDetailRep (private val apiService : TvShowDBInterface) {

    lateinit var comapanyDetailsData: TvShowDetailsData

    fun fetchSingleTvShow (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<TvShowDetails> {

        comapanyDetailsData = TvShowDetailsData(apiService,compositeDisposable)
        comapanyDetailsData.fetchMovieDetails(movieId)

        return comapanyDetailsData.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return comapanyDetailsData.networkState
    }



}

