package com.canra.jetpackmovie.ui.main

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MainViewModelTest {
    lateinit var viewModel: MainViewModel
    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun getDumyMovie() {
        assertNotNull(viewModel.getDumyMovie())
        assertEquals(10, viewModel.getDumyMovie().size.toLong())
    }

    @Test
    fun getDumyTv() {
        assertNotNull(viewModel.getDumyTv())
        assertEquals(10, viewModel.getDumyTv().size.toLong())
    }
}