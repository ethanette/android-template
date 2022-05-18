package com.ethanette.data.di

import com.ethanette.data.sample.mapper.SampleMapper
import com.ethanette.data.sample.repository.SampleRepositoryImpl
import com.ethanette.data.sample.source.SampleLocalDataSource
import com.ethanette.data.sample.source.SampleRemoteDataSource
import com.ethanette.domain.repository.SampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideSampleRepository(
        local: SampleLocalDataSource,
        remote: SampleRemoteDataSource,
        mapper: SampleMapper
    ): SampleRepository = SampleRepositoryImpl(local, remote, mapper)

}