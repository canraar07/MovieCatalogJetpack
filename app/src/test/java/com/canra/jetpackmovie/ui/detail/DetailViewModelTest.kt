package com.canra.jetpackmovie.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.canra.jetpackmovie.data.source.MovieJetpackRepository
import com.canra.jetpackmovie.data.source.remote.network.model.ResponseDetailModel
import com.canra.jetpackmovie.dumydata.DataDumy
import com.canra.jetpackmovie.util.DataItems
import junit.framework.Assert
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class DetailViewModelTest {
    lateinit var viewModel: DetailViewModel
    val movieJetpackRepository = Mockito.mock(MovieJetpackRepository::class.java)
    val dataDumy = DataDumy()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
    }

    @Test
    fun getDetail(){
        val dumyData : ArrayList<ResponseDetailModel> = dataDumy.generetDumyDetailMovie()
        val value = MutableLiveData<ArrayList<ResponseDetailModel>>()
        value.postValue(dumyData)
        `when`(movieJetpackRepository.getDataDetail()).thenReturn(value)
        val observer = Mockito.mock(Observer::class.java) as Observer<ArrayList<ResponseDetailModel>>
        movieJetpackRepository.getDataDetail().observeForever(observer)
        assertNotNull(observer)
        verify(observer).onChanged(dumyData)
    }
}