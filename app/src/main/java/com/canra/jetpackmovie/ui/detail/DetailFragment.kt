package com.canra.jetpackmovie.ui.detail

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.canra.jetpackmovie.R
import com.canra.jetpackmovie.data.source.local.database.Favorit
import com.canra.jetpackmovie.data.source.remote.network.model.ResponseDetailModel
import com.canra.jetpackmovie.espreso.EsspresoIdlingResource
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailFragment : Fragment() {

    companion object {
        fun newInstance(
             id: String,
             type: String
        ) : DetailFragment{
            val fragment = DetailFragment()
            val bundle = Bundle().apply {
                putString("id", id)
                putString("typ", type)
            }
            fragment.arguments = bundle
            return fragment
        }

    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }
    private lateinit var favorit : Favorit
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        val id = arguments?.getString("id")
        val typ = arguments?.getString("typ")
        EsspresoIdlingResource.increment()
        this.context?.let { viewModel.setDataBase(it) }
        this.context?.let { cekFavorit(id.toString(), it) }
        if(typ == "MOVIE"){
            spin_loading_detail.isVisible = true
            scroll_view.isVisible = false
            if (id != null) {
                viewModel.getDetailMovie(id)
            }
        }else{
            spin_loading_detail.isVisible = true
            scroll_view.isVisible = false
            if (id != null) {
                viewModel.getDetailTV(id)
            }
        }
        val myContext = this.context
        viewModel.dataObserver().observe(this, Observer<ArrayList<ResponseDetailModel>>
        { dataDetail ->
            if(dataDetail != null){
                title_movie_detail.text = dataDetail[0].title
                date_rilis_movie_detail.text = dataDetail[0].releaseDate
                rate_movie_detail.text = dataDetail[0].vote.toString()
                overview_movie_detail.text= dataDetail[0].overview
                if (myContext != null) {
                    Glide.with(myContext)
                        .load("https://image.tmdb.org/t/p/w780${dataDetail[0].poster}")
                        .into(image_detail)
                }
                spin_loading_detail.isVisible = false
                scroll_view.isVisible = true
                if (!EsspresoIdlingResource.getEspressoIdlingResourcey().isIdleNow()) {
                    EsspresoIdlingResource.decrement()
                }
                favorit = Favorit(id?.toInt(),dataDetail[0].title,dataDetail[0].poster,
                    dataDetail[0].vote.toString(),dataDetail[0].releaseDate)
            }
        })

        imageFavorit.setOnClickListener {
            viewModel.saveFavorit(favorit)
            Toast.makeText(context,"Save $favorit",Toast.LENGTH_LONG).show()
            val myContext = this.context
            if (myContext != null) {
                Glide.with(myContext)
                    .load(R.drawable.staron)
                    .into(imageFavorit)
            }
        }

        bDelet.setOnClickListener {
            viewModel.deletFavorit(favorit)
        }
    }

    fun cekFavorit(id: String, context: Context){

    }

}
