package com.canra.jetpackmovie.ui.detail


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.canra.jetpackmovie.data.source.MovieJetpackRepository
import com.canra.jetpackmovie.data.source.remote.network.model.ResponseDetailModel

class DetailViewModel : ViewModel() {

    var movieJetpackRepository = MovieJetpackRepository()

    fun getDetailMovie(id : String){
        movieJetpackRepository.getDetailMovie(id,"en-US")
    }

    fun getDetailTV(id : String){
        movieJetpackRepository.getDetailTv(id,"en-US")
    }

    fun dataObserver() : LiveData<ArrayList<ResponseDetailModel>> {
        return movieJetpackRepository.getDataDetail()
    }

}
