package com.canra.jetpackmovie.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.canra.jetpackmovie.R
import com.canra.jetpackmovie.adapter.AdapterListFavorit
import com.canra.jetpackmovie.adapter.AdapterMainActivity
import com.canra.jetpackmovie.adapter.AdapterPageFavoritMovie
import com.canra.jetpackmovie.adapter.AdapterPageFavoritTv
import com.canra.jetpackmovie.dumydata.DataDumy
import com.canra.jetpackmovie.espreso.EsspresoIdlingResource
import com.canra.jetpackmovie.util.DataItems
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: AdapterMainActivity
    private lateinit var  adapterFavorit: AdapterListFavorit
    private lateinit var dataDumy: DataDumy
    private var typeFavorit: String = "MOVIE"
    private val adapterPageFavoritMovie : AdapterPageFavoritMovie by lazy {
        AdapterPageFavoritMovie()
    }
    private val adapterPageFavoritTv : AdapterPageFavoritTv by lazy {
        AdapterPageFavoritTv()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        showLoading(true)
        this.context?.let { viewModel.setDataBaseViemModel(it) }
        dataDumy = DataDumy()
        adapter = AdapterMainActivity()
        adapterFavorit = AdapterListFavorit()
        adapter.dataClear()
        EsspresoIdlingResource.increment()
        viewModel.getListMovie()
        viewModel.dataObserver().observe(this, Observer<ArrayList<DataItems>> {datalist ->
           if(datalist != null){
                adapter.setData(datalist)
                showLoading(false)
               if (!EsspresoIdlingResource.getEspressoIdlingResourcey().isIdleNow()) {
                   EsspresoIdlingResource.decrement()
               }
            }
        })
        recyleviefavorit.layoutManager = GridLayoutManager(this.activity,2)
        recyleviewmenu.layoutManager = GridLayoutManager(this.activity, 2)
        recyleviewmenu.adapter = adapter

        tabmenu.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab.let {
                    if (it != null) {
                        when (it.position) {
                            0 -> {
                                EsspresoIdlingResource.increment()
                                adapter.dataClear()
                                showLoading(true)
                                recyleviewmenu.isVisible=true
                                recyleviefavorit.isVisible=false
                                viewModel.getListMovie()
                            }
                            1 -> {
                                EsspresoIdlingResource.increment()
                                adapter.dataClear()
                                showLoading(true)
                                recyleviewmenu.isVisible=true
                                recyleviefavorit.isVisible=false
                                viewModel.getListTv()
                            }
                            2 -> {
                                recyleviewmenu.isVisible=false
                                recyleviefavorit.isVisible=true
                                viewModel.getPageFavoritMovie().observe(this@MainFragment, Observer {
                                    adapterPageFavoritMovie.submitList(it)
                                    recyleviefavorit.adapter = adapterPageFavoritMovie
                                })
                                typeFavorit = "MOVIE"
                            }
                            3 -> {
                                recyleviewmenu.isVisible=false
                                recyleviefavorit.isVisible=true
                                viewModel.getPageFavoritTv().observe(this@MainFragment, Observer {
                                    adapterPageFavoritTv.submitList(it)
                                    recyleviefavorit.adapter = adapterPageFavoritTv
                                })
                                typeFavorit = "TV"
                            }
                        }
                    }
                }
            }

        })

    }

    private fun showLoading(param: Boolean) {
        spin_loading.isVisible = param
    }
}
