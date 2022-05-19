package com.ajgroup.learndi.data

import retrofit2.http.GET

interface ApiService {
    @GET("movie/popular")
    suspend fun getAllPopularMovies() : PopularMoviesResponse
}