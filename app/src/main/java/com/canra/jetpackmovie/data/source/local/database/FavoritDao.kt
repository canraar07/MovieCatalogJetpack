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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTv(favorit: FavoritTv)

    @Delete
    fun deletTv(favorit: FavoritTv)

    @Query("SELECT * from fav_tv")
    fun getAllFavoritTv() : LiveData<List<FavoritTv>>

    @Query("SELECT * FROM fav_movie WHERE id=:id")
    fun getCekDataFavoritMovie(id : Int) : LiveData<List<Favorit>>

    @Query("SELECT * FROM fav_tv WHERE id=:id")
    fun getCekDataFavoritTv(id : Int) : LiveData<List<FavoritTv>>


}