package com.canra.jetpackmovie.ui.main


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canra.jetpackmovie.data.source.MovieJetpackRepository
import com.canra.jetpackmovie.dumydata.DataDumy
import com.canra.jetpackmovie.util.DataItems
import kotlin.concurrent.thread

class MainViewModel : ViewModel() {
    lateinit var dumy: DataDumy
    lateinit var movieJetpackRepository: MovieJetpackRepository
    var datalist = MutableLiveData<ArrayList<DataItems>>()

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

        val dataItems = movieJetpackRepository.getMovieList("en-US")
        datalist.postValue(dataItems)
    }

    fun getData(): LiveData<ArrayList<DataItems>> {
        return datalist
    }
}
