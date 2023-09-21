package com.rushi.unittest_ld_cr_1.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rushi.unittest_ld_cr_1.data.utils.Resource
import com.rushi.unittest_ld_cr_1.domain.model.PostItem
import com.rushi.unittest_ld_cr_1.domain.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    lateinit var mainViewModel: MainViewModel

    @Mock
    lateinit var mainRepository: MainRepository

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    val myDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(myDispatcher)
        mainViewModel = MainViewModel(mainRepository)
    }

    @Test
    fun testThatValueOfLivedataIsSet() = runTest{
        Mockito.`when`(mainRepository.getPosts()).thenReturn(Resource.Success(listOf(PostItem(),PostItem())))
        mainViewModel.getPosts()
        myDispatcher.scheduler.advanceUntilIdle()
        val actualList = mainViewModel.postsLiveData.getOrAwaitValueTest()
        assertEquals(2,actualList.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}