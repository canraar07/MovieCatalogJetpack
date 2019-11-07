package com.canra.jetpackmovie.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.canra.jetpackmovie.data.source.remote.network.BaseAPi
import com.canra.jetpackmovie.data.source.remote.network.response.ResponseMovie
import com.canra.jetpackmovie.data.source.remote.network.response.ResponseTv
import com.canra.jetpackmovie.network.ApiEndpoind
import com.canra.jetpackmovie.util.DataItems
import retrofit2.Call
import retrofit2.Response

class MovieJetpackRepository : MovieJetpackDataSource {
    var datalist = MutableLiveData<ArrayList<DataItems>>()
    override fun getMovieList(language: String): ArrayList<DataItems> {
        val listItems = ArrayList<DataItems>()
        BaseAPi.creatService(ApiEndpoind::class.java)
            .getListMovie(language)
            .enqueue(object : retrofit2.Callback<ResponseMovie>{
                override fun onResponse(
                    call: Call<ResponseMovie>,
                    response: Response<ResponseMovie>
                ) {
                    response.let { it ->
                        if (response.isSuccessful) {
                            it.body()?.let {
                                val rs = it.itemListMovie?.indices
                                if (rs != null) {
                                    for (i in rs) {
                                        val name = it.itemListMovie[i].name
                                        val image = it.itemListMovie[i].image.toString()
                                        val overview = it.itemListMovie[i].overview
                                        val vote = it.itemListMovie[i].vote_Average
                                        val release = it.itemListMovie[i].release_Date
                                        listItems.add(
                                            DataItems(
                                                name,
                                                image,
                                                overview,
                                                vote,
                                                release
                                            )
                                        )
                                    }

                                }
                            }
                            datalist.postValue(listItems)
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                    Log.e("eroooor :", t.toString())
                }

            })
        return listItems
    }

    override fun getTvList(language: String): ArrayList<DataItems> {
        val listItems = ArrayList<DataItems>()
        BaseAPi.creatService(ApiEndpoind::class.java)
            .getListTvShow(language)
            .enqueue(object : retrofit2.Callback<ResponseTv>{
                override fun onResponse(
                    call: Call<ResponseTv>,
                    response: Response<ResponseTv>
                ) {
                    response.let { it ->
                        if (response.isSuccessful) {
                            it.body()?.let {
                                val rs = it.itemListTv?.indices
                                if (rs != null) {
                                    for (i in rs) {
                                        val name = it.itemListTv[i].name
                                        val image = it.itemListTv[i].image.toString()
                                        val overview = it.itemListTv[i].overview
                                        val vote = it.itemListTv[i].vote_Average
                                        val release = it.itemListTv[i].release_Date
                                        listItems.add(
                                            DataItems(
                                                name,
                                                image,
                                                overview,
                                                vote,
                                                release
                                            )
                                        )
                                    }

                                }
                            }
                            datalist.postValue(listItems)
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseTv>, t: Throwable) {
                    Log.e("eroooor :", t.toString())
                }

            })
        return listItems
    }

    fun getData(): LiveData<ArrayList<DataItems>> {
        return datalist
    }
}