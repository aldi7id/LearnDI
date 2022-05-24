package com.ajgroup.learndi.data

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class RepositoryTest {
    //Collaborator
    private lateinit var apiService: ApiService
    private lateinit var apiHelper: ApiHelper

    //SUT= System Under Test
    private lateinit var repository: Repository

    @Before
    fun setUp() {
        apiService = mockk()
        //dbHelper = mockk()
        apiHelper = ApiHelper(apiService)
        repository = Repository(apiHelper /*, dbHelper*/)
    }

    @Test
    fun getAllPopularMovies(): Unit = runBlocking {
        //Given
        val responseMovies = mockk<PopularMoviesResponse>()
        every {
            runBlocking {
                apiService.getAllPopularMovies()
            }
        } returns responseMovies
        //When
        repository.getAllPopularMovies()

        //Then
        verify {
            runBlocking { apiService.getAllPopularMovies() }
        }
    }
}