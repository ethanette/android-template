package com.ethanette.framework.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

/**
 * # FlowPagingUseCase
 * Execute the business logic in the execute method and continue to post updates to the page data like this:
 * [PagingData<R>].
 * @author ethan
 * @since 2021-11-04
 */
abstract class FlowPagingUseCase<in P, R : Any>(private val coroutineDispatcher: CoroutineDispatcher) {

    operator fun invoke(parameters: P): Flow<PagingData<R>> = execute(parameters)
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(parameters: P): Flow<PagingData<R>>
}
