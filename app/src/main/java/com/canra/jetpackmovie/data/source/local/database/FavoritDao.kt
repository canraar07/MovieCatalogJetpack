package com.canra.jetpackmovie.data.source.local.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavoritDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(favorit: Favorit)

    @Update
    fun update(favorit: Favorit)

    @Delete
    fun delet(favorit: Favorit)

    @Query("SELECT * from favorit ORDER BY id ASC")
    fun getAllFavorit() : LiveData<List<Favorit>>


}