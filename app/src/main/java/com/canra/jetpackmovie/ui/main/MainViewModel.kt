package com.canra.jetpackmovie.ui.main


import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.bumptech.glide.Glide
import com.canra.jetpackmovie.R
import com.canra.jetpackmovie.data.source.FavoritRepository
import com.canra.jetpackmovie.data.source.MovieJetpackRepository
import com.canra.jetpackmovie.data.source.local.database.Favorit
import com.canra.jetpackmovie.data.source.local.database.FavoritDatabase
import com.canra.jetpackmovie.data.source.local.database.FavoritTv
import com.canra.jetpackmovie.dumydata.DataDumy
import com.canra.jetpackmovie.util.DataFavorit
import com.canra.jetpackmovie.util.DataItems
import kotlinx.android.synthetic.main.detail_fragment.*
import java.util.concurrent.Executors

class MainViewModel : ViewModel() {
    var movieJetpackRepository = MovieJetpackRepository()


    fun getListMovie(){
        movieJetpackRepository.getMovieList("en-US")
    }

    fun getListTv(){
        movieJetpackRepository.getTvList("en-US")
    }

    fun dataObserver() : LiveData<ArrayList<DataItems>> {
        return movieJetpackRepository.getData()
    }

    fun setDataBaseViemModel(context : Context){
        movieJetpackRepository.setDataBase(context)
    }

    fun getPageFavoritMovie() : LiveData<PagedList<Favorit>>{
        return movieJetpackRepository.getPageMovieFavorit()
    }

    fun getPageFavoritTv() : LiveData<PagedList<FavoritTv>>{
        return movieJetpackRepository.getPageMovieFavoritTv()
    }



}
