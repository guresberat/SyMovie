package com.guresberat.symovie.util

import com.guresberat.symovie.domain.model.Movie

sealed class DataState{
    data class Success(val data: List<Movie>) : DataState()
    data class Error(val exception: Exception) : DataState()
    object Loading : DataState()
}