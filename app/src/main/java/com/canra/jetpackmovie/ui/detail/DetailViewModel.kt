package com.canra.jetpackmovie.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canra.jetpackmovie.network.ApiEndpoind
import com.canra.jetpackmovie.network.BaseAPi
import com.canra.jetpackmovie.network.model.ResponseDetailModel
import com.canra.jetpackmovie.network.response.ResponseDetailMovie
import com.canra.jetpackmovie.network.response.ResponseDetailTV
import retrofit2.Call
import retrofit2.Response

class DetailViewModel : ViewModel() {
    var dataDetail = MutableLiveData<ArrayList<ResponseDetailModel>>()
    fun getDetailMovie(id: String, lang: String) {
        val data = ArrayList<ResponseDetailModel>()
        BaseAPi.creatService(ApiEndpoind::class.java)
            .getDetailMovie(id, lang)
            .enqueue(object : retrofit2.Callback<ResponseDetailMovie> {
                override fun onResponse(
                    call: Call<ResponseDetailMovie>,
                    response: Response<ResponseDetailMovie>
                ) {
                    response.let {
                        if (response.isSuccessful) {
                            it.body()?.let { it ->
                                val title = it.title
                                val overview = it.overview
                                val poster = it.poster
                                val vote = it.vote
                                val releaseDate = it.releaseDate
                                var genre  = ""
                                for(i in it.genres?.indices!!){
                                    val lastindex = it.genres.lastIndex
                                    genre = when(i){
                                        lastindex -> "${genre}${it.genres[i].name!!}"
                                        else -> "${genre}${it.genres[i].name!!}, "
                                    }
                                }
                                data.add(ResponseDetailModel(title, overview, poster,vote,releaseDate,genre))
                                dataDetail.postValue(data)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseDetailMovie>, t: Throwable) {
                    Log.e("eroooor :", t.toString())
                }

            })
    }

    fun getDetailTv(id: String, lang: String) {
        val data = ArrayList<ResponseDetailModel>()
        BaseAPi.creatService(ApiEndpoind::class.java)
            .getDetailTV(id,lang)
            .enqueue(object : retrofit2.Callback<ResponseDetailTV> {
                override fun onResponse(
                    call: Call<ResponseDetailTV>,
                    response: Response<ResponseDetailTV>
                ) {
                    response.let {
                        if (response.isSuccessful) {
                            it.body()?.let { it ->
                                val title = it.title
                                val overview = it.overview
                                val poster = it.poster
                                val vote = it.vote
                                val releaseDate = it.releaseDate
                                var genre  = ""
                                for(i in it.genres?.indices!!){
                                    val lastindex = it.genres.lastIndex
                                    genre = when(i){
                                        lastindex -> "${genre}${it.genres[i].name!!}"
                                        else -> "${genre}${it.genres[i].name!!}, "
                                    }
                                }
                                data.add(ResponseDetailModel(title, overview, poster,vote,releaseDate, genre))
                                dataDetail.postValue(data)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseDetailTV>, t: Throwable) {
                    Log.e("eroooor :", t.toString())
                }

            })
    }

    fun getDataDetail(): LiveData<ArrayList<ResponseDetailModel>> {
        return dataDetail
    }
}
