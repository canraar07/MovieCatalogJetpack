package com.canra.jetpackmovie.ui.main


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.canra.jetpackmovie.data.source.MovieJetpackRepository
import com.canra.jetpackmovie.dumydata.DataDumy
import com.canra.jetpackmovie.util.DataItems

class MainViewModel : ViewModel() {
    lateinit var dumy: DataDumy
    var movieJetpackRepository = MovieJetpackRepository()

    fun getDumyMovie() : ArrayList<DataItems>{
        dumy = DataDumy()
        return dumy.generateDataDumyListMovie()
    }

    fun getDumyTv() : ArrayList<DataItems>{
        dumy = DataDumy()
        return dumy.generateDataDumyListTV()
    }

    fun getListMovie(){
        movieJetpackRepository.getMovieList("en-US")
    }

    fun getListTv(){
        movieJetpackRepository.getTvList("en-US")
    }

    fun dataObserver() : LiveData<ArrayList<DataItems>> {
        return movieJetpackRepository.getData()
    }


}
