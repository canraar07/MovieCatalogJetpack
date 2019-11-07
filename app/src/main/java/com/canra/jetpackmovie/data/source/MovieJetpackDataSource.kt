package com.canra.jetpackmovie.data.source


import com.canra.jetpackmovie.util.DataItems

interface MovieJetpackDataSource {
    fun getMovieList (language: String) : ArrayList<DataItems>
    fun getTvList (language: String) : ArrayList<DataItems>
}