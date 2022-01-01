package com.rasenyer.showsapp.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rasenyer.showsapp.databinding.ActivityMainBinding
import com.rasenyer.showsapp.ui.adapter.ShowAdapter
import com.rasenyer.showsapp.viewmodel.ShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val showViewModel: ShowViewModel by viewModels()
    private lateinit var showAdapter: ShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerViews()

    }

    private fun setUpRecyclerViews() {

        showAdapter = ShowAdapter()

        binding.mRecyclerView.apply {

            adapter = showAdapter
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

            setHasFixedSize(true)

        }

        showViewModel.responseShow.observe(this, { showList ->

            showAdapter.showList = showList

        })

    }

}