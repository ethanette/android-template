package com.ethanette.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ethanette.domain.model.SampleModel
import com.ethanette.domain.usecase.sample.GetSampleListUseCase
import com.ethanette.domain.usecase.sample.RefreshSampleListUseCase
import com.ethanette.framework.viewmodel.UnidirectionalViewModel
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
class SampleViewModel @Inject constructor(
) : ViewModel(), UnidirectionalViewModel<SampleEvent, SampleEffect, SampleState> {

    private val effectChannel = Channel<SampleEffect>(Channel.UNLIMITED)
    override val effect: Flow<SampleEffect> = effectChannel.receiveAsFlow()
    private val samples = MutableStateFlow(samples())
    override val state: StateFlow<SampleState> =
        samples.map {
            SampleState(
                sampleList = it
            )
        }.stateIn(viewModelScope, SharingStarted.Eagerly, SampleState())

    override fun event(event: SampleEvent) {
    }

    companion object {
        fun samples() = listOf(
            SampleModel(
                id = 0,
                name = "Sample1"
            ),
            SampleModel(
                id = 1,
                name = "Sample2"
            ),
            SampleModel(
                id = 2,
                name = "Sample3"
            ),
            SampleModel(
                id = 3,
                name = "Sample4"
            ),
            SampleModel(
                id = 4,
                name = "Sample5"
            ),
        )
    }

}