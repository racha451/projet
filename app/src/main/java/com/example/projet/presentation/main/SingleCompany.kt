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
import com.example.projet.ViewModel.SingleCompanyViewModel
import com.example.projet.data.Single_company_detail.comapanyDetailRep
import com.example.projet.data.api.CompanyDBClient
import com.example.projet.data.api.CompanyDBInterface
import com.example.projet.data.api.POSTER_BASE_URL
import com.example.projet.data.repository.NetworkState
import com.example.projet.data.vo.CompanyDetails
import kotlinx.android.synthetic.main.activity_single_company.*

class SingleCompany : AppCompatActivity() {

    private lateinit var viewModel: SingleCompanyViewModel
    private lateinit var comapanyRepository: comapanyDetailRep


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_company)

        val companyId: Int = intent.getIntExtra("id",1)

        val apiService : CompanyDBInterface = CompanyDBClient.getClient()
        comapanyRepository = comapanyDetailRep(apiService)

        viewModel = getViewModel(companyId)

        viewModel.companyDetails.observe(this, Observer {
            bindUI(it)
        })

        viewModel.networkState.observe(this, Observer {
            progress_bar.visibility = if (it == NetworkState.LOADING) View.VISIBLE else View.GONE
            txt_error.visibility = if (it == NetworkState.ERROR) View.VISIBLE else View.GONE

        })

    }

    fun bindUI( it: CompanyDetails){
        company_name.text = it.name
        company_description.text = it.description
        company_release_headquarters.text = it.headquarters
        company_homepage.text = it.homepage.toString()
        company_country.text = it.origin_country.toString()




        val companyPosterURL = POSTER_BASE_URL + it.logo_path
        Glide.with(this)
                .load(companyPosterURL)
                .into(iv_movie_poster);


    }


    private fun getViewModel(movieId:Int): SingleCompanyViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return SingleCompanyViewModel(comapanyRepository,movieId) as T
            }
        })[SingleCompanyViewModel::class.java]
    }
}
