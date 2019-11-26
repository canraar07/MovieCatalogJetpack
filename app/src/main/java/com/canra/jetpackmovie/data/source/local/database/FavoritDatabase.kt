package com.canra.jetpackmovie.data.source.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Favorit::class,FavoritTv::class],version = 1 )
abstract class FavoritDatabase : RoomDatabase(){
    abstract fun FavoritDao() : FavoritDao

    companion object {
        private var INSTANCE: FavoritDatabase? = null
        private val sLock = Any()

        fun getInstance(context: Context): FavoritDatabase {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        FavoritDatabase::class.java, "favorit.db"
                    )
                        .build()
                }
                return INSTANCE as FavoritDatabase
            }
        }

    }
}