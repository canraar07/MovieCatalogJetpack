package com.canra.jetpackmovie.ui.main

import androidx.lifecycle.MutableLiveData
import com.canra.jetpackmovie.data.source.MovieJetpackRepository
import com.canra.jetpackmovie.dumydata.DataDumy
import com.canra.jetpackmovie.util.DataItems
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.rules.TestRule
import org.mockito.Mockito.*


class MainViewModelTest {
    lateinit var viewModel: MainViewModel
    val movieJetpackRepository =  mock(MovieJetpackRepository::class.java)
    val dataDumy = DataDumy()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun getListMovie(){
       val dumyData : ArrayList<DataItems> = dataDumy.generateDataDumyListMovie()
       val value = MutableLiveData<ArrayList<DataItems>>()
       value.postValue(dumyData)
       `when`(movieJetpackRepository.getMovieList("en-US")).thenReturn(dataDumy.generateDataDumyListMovie())
        `when`(movieJetpackRepository.getData()).thenReturn(value)
       val observer = mock(Observer::class.java) as Observer<ArrayList<DataItems>>
       movieJetpackRepository.getData().observeForever(observer)
       verify(observer).onChanged(dumyData)
    }

    @Test
    fun getListTv(){
        val dumyData : ArrayList<DataItems> = dataDumy.generateDataDumyListTV()
        val value = MutableLiveData<ArrayList<DataItems>>()
        value.postValue(dumyData)
        `when`(movieJetpackRepository.getTvList("en-US")).thenReturn(dataDumy.generateDataDumyListTV())
        `when`(movieJetpackRepository.getData()).thenReturn(value)
        val observer = mock(Observer::class.java) as Observer<ArrayList<DataItems>>
        movieJetpackRepository.getData().observeForever(observer)
        verify(observer).onChanged(dumyData)
    }
}