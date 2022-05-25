package com.ethanette.domain.usecase.sample

import com.ethanette.domain.di.IoDispatcher
import com.ethanette.domain.repository.SampleRepository
import com.ethanette.framework.usecase.ResultUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * # usecase
 * Package with bussiness logic. UseCase should unite common case logic.
 * UseCase could be splat up in disctinct usecase that carries less logic.
 *
 * Naming convention: feature name + UseCase suffix
 *
 * @author hsjun85
 * @since 2022-05-25
 */
class RefreshSampleUseCase @Inject constructor(
    private val repository: SampleRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : ResultUseCase<Int, Boolean>(dispatcher) {

    override suspend fun execute(parameters: Int): Boolean {
        repository.refreshSample(parameters)
        return true
    }

}