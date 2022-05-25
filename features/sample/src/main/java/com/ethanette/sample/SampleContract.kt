package com.ethanette.sample

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ethanette.domain.model.SampleModel
import com.ethanette.sample.SampleViewModel

/**
 * # SampleContract
 * sample contract
 *
 * @author hsjun85
 * @since 2022/05/26
 */

data class SampleState(
    val sampleList: List<SampleModel> = emptyList(),
)

object SampleEvent
object SampleEffect

@Composable
fun sampleViewModel(): SampleViewModel = hiltViewModel()