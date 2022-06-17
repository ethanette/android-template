package com.ethanette.data.local.db

import com.ethanette.data.local.sample.dao.SampleEntityDao
import com.ethanette.testutils.TestRobolectric
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Test

/**
 * # android-template
 * # Sample Database Test
 * @author hsjun85
 * @since 2022/06/17
 */
class SampleDatabaseTest: TestRobolectric() {

    @MockK
    lateinit var database: SampleDatabase

    @MockK
    lateinit var sampleEntityDao: SampleEntityDao

    @Test
    fun checkSampleEntityDao() {
        every { database.sampleEntityDao() } returns sampleEntityDao


    }


}