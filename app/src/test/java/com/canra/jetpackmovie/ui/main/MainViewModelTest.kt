package com.canra.jetpackmovie.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.canra.jetpackmovie.mock
import com.canra.jetpackmovie.util.DataItems
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MainViewModelTest {
    private lateinit var mainviewmodel : MainViewModel
    private val observer : Observer <ArrayList<DataItems>> = mock()
    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mainviewmodel= MainViewModel()
        mainviewmodel.datalist.observeForever(observer)

    }

    @Test
    fun getDatalist() {

        print((mainviewmodel.datalist.value).toString())
    }

    @Test
    fun setDatalist() {
        val listItems = ArrayList<DataItems>()
        listItems.add(DataItems("1243","abcde","jdsjdhs","movie"))
        mainviewmodel.setData(listItems)
        mainviewmodel.datalist.value
        print((mainviewmodel.datalist.value).toString())

    }

    @Test
    fun getListMovie() {
        mainviewmodel.getListMovie("en-En")
    }

    @Test
    fun getListTV() {
        mainviewmodel.getListTV("en-En")
    }

    @Test
    fun getData() {
        print(mainviewmodel.getData().value)
    }
}