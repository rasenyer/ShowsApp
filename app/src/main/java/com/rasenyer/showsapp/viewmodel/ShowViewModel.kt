package com.rasenyer.showsapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rasenyer.showsapp.datasource.remote.models.Show
import com.rasenyer.showsapp.repository.ShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowViewModel
@Inject
constructor(private val showRepository: ShowRepository) : ViewModel() {

    private val _response = MutableLiveData<List<Show>>()
    val responseShow: LiveData<List<Show>>
        get() = _response

    init { getShows() }

    private fun getShows() = viewModelScope.launch {

        showRepository.getShows().let { response ->

            if (response.isSuccessful) { _response.postValue(response.body()) }
            else { Log.d("tag", "getShows Error: ${response.code()}") }

        }

    }

}