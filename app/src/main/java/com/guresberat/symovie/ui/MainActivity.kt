package com.guresberat.symovie.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.guresberat.symovie.databinding.ActivityMainBinding
import com.guresberat.symovie.domain.model.Movie
import com.guresberat.symovie.util.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetMovieEvents)
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(this, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Movie>> -> {
                    displayProgressBar(false)
                    appendMovies(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayError(message: String?) {
        if (message != null) {
            binding.text.text = message
        }
        else{
            binding.text.text = "Unknown Error"
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean){
        binding.progressBar.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }

    private fun appendMovies(movies: List<Movie>){
        val sb = StringBuilder()
        for(movie in movies){
            sb.append(movie.title + "\n")
        }
        binding.text.text = sb.toString()
    }
}