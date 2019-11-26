package com.canra.jetpackmovie.ui.detail


import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.canra.jetpackmovie.data.source.FavoritRepository
import com.canra.jetpackmovie.data.source.MovieJetpackRepository
import com.canra.jetpackmovie.data.source.local.database.Favorit
import com.canra.jetpackmovie.data.source.local.database.FavoritDatabase
import com.canra.jetpackmovie.data.source.local.database.FavoritTv
import com.canra.jetpackmovie.data.source.remote.network.model.ResponseDetailModel
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class DetailViewModel : ViewModel() {

    var movieJetpackRepository = MovieJetpackRepository()
    lateinit var favoritRepository : FavoritRepository

    fun getDetailMovie(id : String){
        movieJetpackRepository.getDetailMovie(id,"en-US")
    }

    fun getDetailTV(id : String){
        movieJetpackRepository.getDetailTv(id,"en-US")
    }

    fun dataObserver() : LiveData<ArrayList<ResponseDetailModel>> {
        return movieJetpackRepository.getDataDetail()
    }

    fun saveFavorit(favorit: Favorit){
        favoritRepository.insert(favorit)
    }

    fun getFavoritMovieByid(id : Int) : LiveData<List<Favorit>>{
       return  favoritRepository.getFavoritMovieByid(id)
    }

    fun getFavoritTvByid(id : Int) : LiveData<List<FavoritTv>>{
        return  favoritRepository.getFavoritTvByid(id)
    }

    fun deletFavorit(favorit: Favorit){
        favoritRepository.delet(favorit)
    }

    fun deletFavoritTv(favorit: FavoritTv){
        favoritRepository.deletTv(favorit)
    }

    fun setDataBase(context : Context){
        val db = FavoritDatabase.getInstance(context)
        favoritRepository = FavoritRepository(db.FavoritDao(), Executors.newSingleThreadExecutor())
    }

    fun saveFavoritTv(favorit: FavoritTv){
        favoritRepository.insertTv(favorit)
    }

}
