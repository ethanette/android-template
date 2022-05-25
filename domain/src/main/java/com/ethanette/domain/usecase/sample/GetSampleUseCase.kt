package com.ethanette.domain.usecase.sample

import com.ethanette.domain.di.IoDispatcher
import com.ethanette.domain.exception.SampleException
import com.ethanette.domain.model.SampleModel
import com.ethanette.domain.repository.SampleRepository
import com.ethanette.framework.model.Result
import com.ethanette.framework.usecase.FlowResultUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
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
class GetSampleUseCase @Inject constructor(
    private val repository: SampleRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : FlowResultUseCase<Int, SampleModel>(dispatcher) {

    override fun execute(parameters: Int): Flow<Result<SampleModel>> =
        repository.observeSample(parameters).transform {
            emit(it?.let {
                Result.Success(it)
            } ?: run { Result.Error(SampleException("Sample model does not exist")) })
        }

}