package com.canra.jetpackmovie.ui.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.canra.jetpackmovie.R

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

    }

}
