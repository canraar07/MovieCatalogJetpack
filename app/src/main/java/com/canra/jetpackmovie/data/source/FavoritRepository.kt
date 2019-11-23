package com.canra.jetpackmovie.data.source

import android.app.Application
import androidx.lifecycle.LiveData
import com.canra.jetpackmovie.data.source.local.database.Favorit
import com.canra.jetpackmovie.data.source.local.database.FavoritDao
import com.canra.jetpackmovie.data.source.local.database.FavoritDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoritRepository {
    private var favoritDao : FavoritDao? = null
    private var executorService: ExecutorService? = null

    fun FavoritRepository(application: Application){
        executorService = Executors.newSingleThreadExecutor()

        val db = FavoritDatabase.getInstance(application)
        favoritDao = db.FavoritDao()
    }

    fun getAllFavorit() : LiveData<List<Favorit>> {
        return favoritDao!!.getAllFavorit()
    }

    fun insert(favorit: Favorit){
        executorService?.execute(object : Runnable{
            override fun run() {
                favoritDao?.insert(favorit)
            }
        })
    }

    fun delet(favorit: Favorit){
        executorService?.execute(object  : Runnable{
            override fun run() {
                favoritDao?.delet(favorit)
            }

        })
    }



}