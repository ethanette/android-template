package com.ethanette.framework.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kotlinx.coroutines.flow.*

/**
 * # BaseViewModel
 * MVI base view model
 * @author hsjun85
 * @since 2022/05/26
 */

interface UnidirectionalViewModel<EVENT, EFFECT, STATE> {
    val state: StateFlow<STATE>
    val effect: Flow<EFFECT>
    fun event(event: EVENT)
}

data class StateEffectDispatch<STATE, EFFECT, ACTION>(
    val state: STATE,
    val effectFlow: Flow<EFFECT>,
    val dispatch: (ACTION) -> Unit,
)

@Composable
inline fun <reified STATE, EFFECT, ACTION> use(
    viewModel: UnidirectionalViewModel<ACTION, EFFECT, STATE>
): StateEffectDispatch<STATE, EFFECT, ACTION> {
    val state by viewModel.state.collectAsState()

    val dispatch: (ACTION) -> Unit = { event ->
        viewModel.event(event)
    }

    return StateEffectDispatch(
        state = state,
        effectFlow = viewModel.effect,
        dispatch = dispatch
    )
}