package com.ethanette.app.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ethanette.domain.usecase.sample.GetSampleListUseCase
import com.ethanette.domain.usecase.sample.RefreshSampleListUseCase
import com.ethanette.framework.viewmodel.UnidirectionalViewModel
import com.ethanette.theme.ThemeType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * # SampleViewModel
 * sample view model
 *
 * @author hsjun85
 * @since 2022/05/26
 */

@HiltViewModel
class MainViewModel @Inject constructor(
) : ViewModel(), UnidirectionalViewModel<MainEvent, MainEffect, MainState> {

    private val effectChannel = Channel<MainEffect>(Channel.UNLIMITED)
    override val effect: Flow<MainEffect> = effectChannel.receiveAsFlow()

    private val theme: MutableStateFlow<ThemeType> = MutableStateFlow(ThemeType.DEFAULT)
    override val state: StateFlow<MainState> = theme.map {
        MainState(
            theme = it
        )
    }.stateIn(viewModelScope, SharingStarted.Eagerly, MainState())

    override fun event(event: MainEvent) {}

}