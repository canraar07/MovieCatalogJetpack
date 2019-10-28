package com.canra.jetpackmovie.ui.main

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canra.jetpackmovie.network.ApiEndpoind
import com.canra.jetpackmovie.network.BaseAPi
import com.canra.jetpackmovie.network.response.ResponseMovie
import com.canra.jetpackmovie.network.response.ResponseTv
import com.canra.jetpackmovie.util.DataItems
import retrofit2.Call
import retrofit2.Response

class MainViewModel : ViewModel() {
    var datalist = MutableLiveData<ArrayList<DataItems>>()

    fun getListMovie(language: String) {
        val listItems = ArrayList<DataItems>()
        BaseAPi.creatService(ApiEndpoind::class.java)
            .getListMovie(language)
            .enqueue(object : retrofit2.Callback<ResponseMovie> {
                override fun onResponse(
                    call: Call<ResponseMovie>,
                    response: Response<ResponseMovie>
                ) {
                    response.let {
                        if (response.isSuccessful) {
                            it.body()?.let {
                                val response = it.itemListMovie?.indices
                                if (response != null) {
                                    for (i in response) {
                                        val name = it.itemListMovie[i].name
                                        val image = it.itemListMovie[i].image.toString()
                                        val id = it.itemListMovie[i].id
                                        val type = "movie"
                                        listItems.add(
                                            DataItems(
                                                id,
                                                name,
                                                image,
                                                type
                                            )
                                        )
                                    }
                                    setData(listItems)
                                }

                            }
                        } else {

                        }
                    }
                }


                override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                    Log.e("eroooor :", t.toString())

                }
            })
    }

    fun getListTV(language: String) {
        val listItems = ArrayList<DataItems>()
        BaseAPi.creatService(ApiEndpoind::class.java)
            .getListTvShow(language)
            .enqueue(object : retrofit2.Callback<ResponseTv> {
                override fun onResponse(
                    call: Call<ResponseTv>,
                    response: Response<ResponseTv>
                ) {
                    response.let {
                        if (response.isSuccessful) {
                            it.body()?.let {
                                val response = it.itemListTv?.indices
                                if (response != null) {
                                    for (i in response) {
                                        val name = it.itemListTv[i].name
                                        val image = it.itemListTv[i].image.toString()
                                        val id = it.itemListTv[i].id
                                        val type = "tv"
                                        listItems.add(
                                            DataItems(
                                                id,
                                                name,
                                                image,
                                                type
                                            )
                                        )
                                    }
                                    setData(listItems)
                                }

                            }
                        } else {

                        }
                    }
                }


                override fun onFailure(call: Call<ResponseTv>, t: Throwable) {
                    Log.e("eroooor :", t.toString())

                }
            })
    }

    fun setData(listdata : ArrayList<DataItems>){
        datalist.postValue(listdata)
    }

    fun getData(): LiveData<ArrayList<DataItems>> {
        return datalist
    }
}
