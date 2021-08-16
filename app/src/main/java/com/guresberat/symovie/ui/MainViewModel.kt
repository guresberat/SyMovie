package com.guresberat.symovie.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.guresberat.symovie.domain.model.Movie
import com.guresberat.symovie.repository.MainRepository
import com.guresberat.symovie.util.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class MainViewModel
@ViewModelInject
constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Movie>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Movie>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetMovieEvents -> {
                    mainRepository.getMovie()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.None -> {
                    // lel
                }
            }
        }
    }
}

sealed class MainStateEvent {
    object GetMovieEvents : MainStateEvent()

    object None : MainStateEvent()
}

