package com.canra.jetpackmovie.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import com.canra.jetpackmovie.data.source.local.database.Favorit
import com.canra.jetpackmovie.data.source.local.database.FavoritDao
import com.canra.jetpackmovie.data.source.local.database.FavoritTv
import java.util.concurrent.Executor

class FavoritRepository (
    val favoritDao: FavoritDao,
    val executorService: Executor
){


    fun getAllFavorit() : LiveData<List<Favorit>> {
        return favoritDao.getAllFavorit()
    }

    fun insert(favorit: Favorit){
        executorService.execute(object : Runnable{
            override fun run() {
                favoritDao.insert(favorit)
            }
        })
    }

    fun delet(favorit: Favorit){
        executorService.execute(object  : Runnable{
            override fun run() {
                favoritDao.delet(favorit)
            }

        })
    }

    fun getAllFavoritTv() : LiveData<List<FavoritTv>> {
        return favoritDao.getAllFavoritTv()
    }

    fun insertTv(favorit: FavoritTv){
        executorService.execute(object : Runnable{
            override fun run() {
                favoritDao.insertTv(favorit)
            }
        })
    }

    fun deletTv(favorit: FavoritTv){
        executorService.execute(object  : Runnable{
            override fun run() {
                favoritDao.deletTv(favorit)
            }

        })
    }

    fun getFavoritMovieByid(id : Int) : LiveData<List<Favorit>> {
       return favoritDao.getCekDataFavoritMovie(id)
    }

    fun getFavoritTvByid(id : Int) : LiveData<List<FavoritTv>> {
        return favoritDao.getCekDataFavoritTv(id)
    }



}