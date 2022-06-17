package com.ethanette.data.local.di

import android.content.Context
import com.ethanette.data.local.BuildConfig
import com.ethanette.data.local.db.SampleDatabase
import com.ethanette.data.local.sample.SampleLocalDataSourceImpl
import com.ethanette.data.local.sample.dao.SampleEntityDao
import com.ethanette.data.local.sample.mapper.SampleEntityMapper
import com.ethanette.testutils.MockkUnitTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * # android-template
 * # Local Module Test
 * @author hsjun85
 * @since 2022/06/17
 */
class LocalModuleTest : MockkUnitTest() {

    private lateinit var localModule: LocalModule

    override fun onCreate() {
        super.onCreate()
        localModule = LocalModule()
    }

    @Test
    fun verifyProvideDatabaseName() {
        val databaseName = localModule.provideDatabaseName()
        assertEquals(databaseName, BuildConfig.DB_NAME)
    }

    @Test
    fun verifyProvideDatabase() {
        val context: Context = mockk()
        val databaseName = localModule.provideDatabaseName()
        val database = localModule.provideDatabase(databaseName, context)

        Assert.assertNotNull(database.sampleEntityDao())
    }

    @Test
    fun verifyProvideSampleDao() {
        val database: SampleDatabase = mockk()
        val dao: SampleEntityDao = mockk()

        every { database.sampleEntityDao() } returns dao

        assertEquals(dao, localModule.provideSampleDao(database))

        verify { database.sampleEntityDao() }
    }

    @Test
    fun verifySampleLocalDataSource() {
        val dao = mockk<SampleEntityDao>()
        val mapper = mockk<SampleEntityMapper>()
        val datasource =
            localModule.provideSampleLocalDataSource(dao, mapper) as SampleLocalDataSourceImpl

        assertEquals(dao, datasource.dao)
        assertEquals(mapper, datasource.mapper)

    }

}