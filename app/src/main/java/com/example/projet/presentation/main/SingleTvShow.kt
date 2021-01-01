package com.example.projet.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.projet.R
import com.example.projet.ViewModel.SingleTvShowViewModel

import com.example.projet.data.api.TvShowDBClient
import com.example.projet.data.api.TvShowDBInterface
import com.example.projet.data.api.POSTER_BASE_URL
import com.example.projet.data.repository.NetworkState
import com.example.projet.data.vo.TvShowDetails
import kotlinx.android.synthetic.main.activity_single_tvshow.*
import com.example.projet.data.singletvshowdetail.TvShowDetailRep
import java.text.NumberFormat
import java.util.*

class SingleTvShow : AppCompatActivity() {

    private lateinit var viewModel: SingleTvShowViewModel
    private lateinit  var movieRepository: TvShowDetailRep



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_tvshow)

        val Id: Int = intent.getIntExtra("id",1)

        val apiService : TvShowDBInterface = TvShowDBClient.getClient()
        movieRepository =TvShowDetailRep(apiService)

        viewModel = getViewModel(Id)

        viewModel.tvshowdetails.observe(this, Observer {
            bindUI(it)
        })

        viewModel.networkState.observe(this, Observer {
            progress_bar.visibility = if (it == NetworkState.LOADING) View.VISIBLE else View.GONE
            txt_error.visibility = if (it == NetworkState.ERROR) View.VISIBLE else View.GONE

        })

    }

    fun bindUI( it: TvShowDetails){
        tvshow_name.text = it.name
        tvshow_langage.text = it.languages.toString()
        tvshow_production_countries.text = it.production_countries.toString()
        tvshow_popularity.text = it.popularity.toString()
        tvshow_homepage.text = it.homepage.toString() + " minutes"

        val formatCurrency = NumberFormat.getCurrencyInstance(Locale.US)


        val moviePosterURL = POSTER_BASE_URL + it.poster_path
        Glide.with(this)
                .load(moviePosterURL)
                .into(iv_tvshow_poster);


    }


    private fun getViewModel(movieId:Int): SingleTvShowViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return SingleTvShowViewModel(movieRepository,movieId) as T
            }
        })[SingleTvShowViewModel::class.java]
    }
}
