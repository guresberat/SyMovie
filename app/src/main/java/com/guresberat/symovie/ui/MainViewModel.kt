package com.guresberat.symovie.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guresberat.symovie.repository.MainRepository
import com.guresberat.symovie.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val mainRepository: MainRepository,
) : ViewModel() {

    val dataState: MutableStateFlow<DataState>
        get() = _dataState

    private val _dataState = MutableStateFlow<DataState>(DataState.Loading)

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

