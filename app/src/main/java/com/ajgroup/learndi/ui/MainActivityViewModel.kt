package com.ajgroup.learndi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajgroup.learndi.data.PopularMoviesResponse
import com.ajgroup.learndi.data.Repository
import com.ajgroup.learndi.data.Resource
import kotlinx.coroutines.launch

class MainActivityViewModel(private val repository: Repository): ViewModel() {
    private val _movies = MutableLiveData<Resource<PopularMoviesResponse>>()
    val movies: LiveData<Resource<PopularMoviesResponse>>
    get() = _movies

    fun getAllPopularMovies(){
        viewModelScope.launch {
            _movies.postValue(Resource.loading())
            try {
                _movies.postValue(Resource.success(repository.getAllPopularMovies()))
            } catch (exception: Exception){
                _movies.postValue(Resource.error(exception.message ?: "Error Occured"))
            }
        }
    }
}