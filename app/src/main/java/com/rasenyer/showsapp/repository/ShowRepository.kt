package com.rasenyer.showsapp.repository

import com.rasenyer.showsapp.datasource.remote.api.ApiService
import javax.inject.Inject

class ShowRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getShows() = apiService.getShows()
}