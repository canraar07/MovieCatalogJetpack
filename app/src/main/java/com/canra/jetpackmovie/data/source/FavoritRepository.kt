package com.canra.jetpackmovie.data.source

import androidx.lifecycle.LiveData
import com.canra.jetpackmovie.data.source.local.database.Favorit
import com.canra.jetpackmovie.data.source.local.database.FavoritDao
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



}