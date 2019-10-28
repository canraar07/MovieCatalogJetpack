package com.canra.jetpackmovie.ui.main


import androidx.lifecycle.ViewModel
import com.canra.jetpackmovie.dumydata.DataDumy
import com.canra.jetpackmovie.util.DataItems

class MainViewModel : ViewModel() {
    lateinit var dumy: DataDumy
    fun getDumyMovie() : ArrayList<DataItems>{
        dumy = DataDumy()
        return dumy.generateDataDumyListMovie()
    }

    fun getDumyTv() : ArrayList<DataItems>{
        dumy = DataDumy()
        return dumy.generateDataDumyListTV()
    }
}
