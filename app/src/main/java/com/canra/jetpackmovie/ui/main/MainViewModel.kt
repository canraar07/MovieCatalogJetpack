package com.canra.jetpackmovie.ui.main


import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.canra.jetpackmovie.R
import com.canra.jetpackmovie.data.source.FavoritRepository
import com.canra.jetpackmovie.data.source.MovieJetpackRepository
import com.canra.jetpackmovie.data.source.local.database.Favorit
import com.canra.jetpackmovie.data.source.local.database.FavoritDatabase
import com.canra.jetpackmovie.dumydata.DataDumy
import com.canra.jetpackmovie.util.DataFavorit
import com.canra.jetpackmovie.util.DataItems
import kotlinx.android.synthetic.main.detail_fragment.*
import java.util.concurrent.Executors

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

    fun dataObserverFavorit() : LiveData<ArrayList<DataFavorit>> {
        return movieJetpackRepository.getDataLiveavorit()
    }

    fun setDataBaseViemModel(context : Context){
        movieJetpackRepository.setDataBase(context)
    }

    fun getDataFavorit() : LiveData<List<Favorit>>{
        return movieJetpackRepository.getDataFavorit()
    }

    fun setDataFavoritShow(favorit : List<Favorit>){
        movieJetpackRepository.setDataFavoritShow(favorit)
    }

}
