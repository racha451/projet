package com.example.projet.data.vo

data class ListTvSow(
    val page: Int,
    val tvShowList: List<TvShow>,
    val total_pages: Int,
    val total_results: Int
)