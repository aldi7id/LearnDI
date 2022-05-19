package com.ajgroup.learndi.data

class ApiHelper(val apiService: ApiService) {
    suspend fun getAllPopularMovies() = apiService.getAllPopularMovies()

}