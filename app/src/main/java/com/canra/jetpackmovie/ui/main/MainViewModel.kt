package com.canra.jetpackmovie.ui.main


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.canra.jetpackmovie.data.source.MovieJetpackRepository
import com.canra.jetpackmovie.dumydata.DataDumy
import com.canra.jetpackmovie.util.DataItems
import kotlin.concurrent.thread

class MainViewModel : ViewModel() {
    lateinit var dumy: DataDumy
    lateinit var movieJetpackRepository: MovieJetpackRepository

    fun getDumyMovie() : ArrayList<DataItems>{
        dumy = DataDumy()
        return dumy.generateDataDumyListMovie()
    }

    fun getDumyTv() : ArrayList<DataItems>{
        dumy = DataDumy()
        return dumy.generateDataDumyListTV()
    }

    fun getListMovie(){
        movieJetpackRepository= MovieJetpackRepository()

        movieJetpackRepository.getMovieList("en-US")

    }

    fun getListTv(){
        movieJetpackRepository= MovieJetpackRepository()

        movieJetpackRepository.getTvList("en-US")

    }

    fun dataObserver() : LiveData<ArrayList<DataItems>> {
        return movieJetpackRepository.getData()
    }


}
