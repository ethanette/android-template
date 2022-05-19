package com.ethanette.framework.usecase

import com.ethanette.framework.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * # UseCase
 * Executes business logic synchronously or asynchronously using Coroutines.
 * @author ethan
 * @since 2021-11-04
 */
abstract class ResultUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    /**
     * Executes the use case asynchronously and returns a [Result].
     * @return a [Result].
     * @param parameters the input parameters to run the use case with
     */
    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    Result.Success(it)
                }
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    /**
     * Override this to set the code to be executed.
     */
    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R

}