package com.ethanette.testutils

import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.junit.Rule

/**
 * # android-template
 * # Mockk Unit Test
 * @author hsjun85
 * @since 2022/06/17
 */
open class MockkUnitTest {

    @get:Rule
    var testCoroutineRule = TestCoroutineRule()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        onCreate()
    }

    @After
    fun tearDown() {
        onDestroy()
        unmockkAll()
        clearAllMocks()
    }

    open fun onCreate() {}

    open fun onDestroy() {}

}