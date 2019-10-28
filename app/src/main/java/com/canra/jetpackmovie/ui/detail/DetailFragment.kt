package com.canra.jetpackmovie.ui.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.canra.jetpackmovie.R
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailFragment : Fragment() {

    companion object {
        fun newInstance(
             img : String?,
             title : String?,
             overview : String?,
             release_date : String?,
             vote_average : String?
        ) : DetailFragment{
            val fragment = DetailFragment()
            val bundle = Bundle().apply {
                putString("img", img)
                putString("title", title)
                putString("overview", overview)
                putString("release_date", release_date)
                putString("vote_average", vote_average)
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        val myContext = this.context
        val img = arguments?.getString("img")
        val title = arguments?.getString("title")
        val overview = arguments?.getString("overview")
        val release_date = arguments?.getString("release_date")
        val vote_average = arguments?.getString("vote_average")

        myContext?.let {
            Glide.with(it)
                .load("https://image.tmdb.org/t/p/w780${img}")
                .into(image_detail)
            title_movie_detail.text = title
            date_rilis_movie_detail.text = release_date
            rate_movie_detail.text = vote_average
            overview_movie_detail.text= overview
        }

    }

}
