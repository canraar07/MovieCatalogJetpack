package com.canra.jetpackmovie.data.source.local.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Favorit (
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id")
    val id : String?,

    @ColumnInfo(name = "title")
    val title : String?,

    @ColumnInfo(name = "poster")
    val poster : String?,

    @ColumnInfo(name = "vote")
    val vote : String?,

    @ColumnInfo(name = "releaseDate")
    val releaseDate : String?
) : Parcelable