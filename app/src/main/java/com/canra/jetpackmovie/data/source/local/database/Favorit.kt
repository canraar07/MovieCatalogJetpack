package com.canra.jetpackmovie.data.source.local.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "fav_movie")
data class Favorit (
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id")
    var id : Int?,

    @ColumnInfo(name = "title")
    var title : String?,

    @ColumnInfo(name = "poster")
    var poster : String?,

    @ColumnInfo(name = "vote")
    var vote : String?,

    @ColumnInfo(name = "releaseDate")
    var releaseDate : String?
) : Parcelable