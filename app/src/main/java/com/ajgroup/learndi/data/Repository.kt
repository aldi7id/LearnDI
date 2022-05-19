package com.ajgroup.learndi.data

class Repository(val apiHelper: ApiHelper) {
    suspend fun getAllPopularMovies() = apiHelper.getAllPopularMovies()
}