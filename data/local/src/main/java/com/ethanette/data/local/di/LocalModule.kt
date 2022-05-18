package com.ethanette.data.local.di

import android.content.Context
import com.ethanette.data.local.db.LocalDatabase
import com.ethanette.data.local.sample.SampleLocalDataSourceImpl
import com.ethanette.data.local.sample.dao.SampleEntityDao
import com.ethanette.data.local.sample.mapper.SampleEntityMapper
import com.ethanette.data.sample.source.SampleLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): LocalDatabase {
        return LocalDatabase.buildDatabase(context)
    }

    @Provides
    @Singleton
    fun provideCharacterFavoriteDao(localDatabase: LocalDatabase): SampleEntityDao {
        return localDatabase.sampleEntityDao()
    }

    @Provides
    @Singleton
    fun provideSampleLocalDataSource(
        dao: SampleEntityDao,
        mapper: SampleEntityMapper
    ): SampleLocalDataSource {
        return SampleLocalDataSourceImpl(dao, mapper)
    }

}