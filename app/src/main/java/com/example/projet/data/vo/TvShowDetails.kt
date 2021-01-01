package com.example.projet.data.vo


data class TvShowDetails (
    val backdrop_path: String,
    val created_by: List<Any>,
    val episode_run_time: List<Int>,
    val first_air_date: String,
    val homepage: String,
    val id: Int,
    val in_production: Boolean,
    val languages: List<String>,
    val last_air_date: String,
    val name: String,

    val next_episode_to_air: Any,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<Any>,
    val production_countries: List<Any>,

    val status: String,
    val tagline: String,
    val type: String
)