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
import com.canra.jetpackmovie.adapter.AdapterMainActivity
import com.canra.jetpackmovie.util.DataItems
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: AdapterMainActivity
    private var listItems = ArrayList<DataItems>()

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
        viewModel.getListMovie("en-US")
        adapter = AdapterMainActivity()
        adapter.dataClear()
        viewModel.getData().observe(this, Observer<ArrayList<DataItems>> {datalist ->
            if(datalist != null){
                adapter.setData(datalist)
                showLoading(false)
                listItems = datalist
            }
        })
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
                                adapter.dataClear()
                                showLoading(true)
                                viewModel.getListMovie("en-US")
                            }
                            1 -> {
                                adapter.dataClear()
                                showLoading(true)
                                viewModel.getListTV("en-US")
                            }
                        }
                    }
                }
            }

        })
        adapter.notifyDataSetChanged()
        recyleviewmenu.layoutManager = GridLayoutManager(this.activity, 2)
        recyleviewmenu.adapter = adapter


    }

    private fun showLoading(param: Boolean) {
        spin_loading.isVisible = param
    }
}
