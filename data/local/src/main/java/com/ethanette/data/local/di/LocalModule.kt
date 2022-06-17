package com.ethanette.data.local.di

import android.content.Context
import androidx.room.Room
import com.ethanette.data.local.BuildConfig
import com.ethanette.data.local.db.SampleDatabase
import com.ethanette.data.local.sample.SampleLocalDataSourceImpl
import com.ethanette.data.local.sample.dao.SampleEntityDao
import com.ethanette.data.local.sample.mapper.SampleEntityMapper
import com.ethanette.data.sample.source.SampleLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

private const val DB_NAME = "db_name"

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    @Named(value = DB_NAME)
    fun provideDatabaseName(): String {
        return BuildConfig.DB_NAME
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @Named(value = DB_NAME) dbname: String,
        @ApplicationContext context: Context
    ): SampleDatabase {
        return Room.databaseBuilder(context, SampleDatabase::class.java, dbname)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideSampleDao(sampleDatabase: SampleDatabase): SampleEntityDao {
        return sampleDatabase.sampleEntityDao()
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