package com.canra.jetpackmovie.util

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataPojoDetailMovie(val id : String?, val typ : String?
                               ) : Parcelable