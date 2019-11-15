package com.canra.jetpackmovie.ui.main

import android.database.ContentObserver
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.canra.jetpackmovie.R
import com.canra.jetpackmovie.adapter.AdapterMainActivity
import com.canra.jetpackmovie.dumydata.DataDumy
import com.canra.jetpackmovie.espreso.EsspresoIdlingResource
import com.canra.jetpackmovie.util.DataItems
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.main_fragment.*
import kotlin.properties.Delegates

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: AdapterMainActivity
    private lateinit var dataDumy: DataDumy

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
        dataDumy = DataDumy()
        adapter = AdapterMainActivity()
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
                                viewModel.getListMovie()
                            }
                            1 -> {
                                EsspresoIdlingResource.increment()
                                adapter.dataClear()
                                showLoading(true)
                                viewModel.getListTv()
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
