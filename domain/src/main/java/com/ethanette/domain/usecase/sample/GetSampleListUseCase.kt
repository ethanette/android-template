package com.ethanette.domain.usecase.sample

import com.ethanette.domain.di.IoDispatcher
import com.ethanette.domain.model.SampleModel
import com.ethanette.domain.repository.SampleRepository
import com.ethanette.framework.usecase.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
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
class GetSampleListUseCase @Inject constructor(
    private val repository: SampleRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): FlowUseCase<Unit, List<SampleModel>>(dispatcher) {

    override fun execute(parameters: Unit): Flow<List<SampleModel>>
        = repository.observeSampleList()

}