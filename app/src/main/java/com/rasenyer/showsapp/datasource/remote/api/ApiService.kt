package com.rasenyer.showsapp.datasource.remote.api

import com.rasenyer.showsapp.utils.Constants
import com.rasenyer.showsapp.datasource.remote.response.ShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getShows(): Response<ShowResponse>

}