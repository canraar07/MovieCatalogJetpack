package com.canra.jetpackmovie.data.source.local.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavoritDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(favorit: Favorit)

    @Delete
    fun delet(favorit: Favorit)

    @Query("SELECT * from fav_movie")
    fun getAllFavorit() : LiveData<List<Favorit>>

}