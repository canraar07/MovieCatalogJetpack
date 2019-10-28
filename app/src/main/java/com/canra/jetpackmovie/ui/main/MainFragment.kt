package com.canra.jetpackmovie.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.canra.jetpackmovie.R
import com.canra.jetpackmovie.adapter.AdapterMainActivity
import com.canra.jetpackmovie.dumydata.DataDumy
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.main_fragment.*

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
        dataDumy = DataDumy()
        adapter = AdapterMainActivity()
        adapter.dataClear()
        adapter.setData(dataDumy.generateDataDumyListMovie())
        adapter.notifyDataSetChanged()
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
                                adapter.dataClear()
                                adapter.setData(dataDumy.generateDataDumyListMovie())
                            }
                            1 -> {
                                adapter.dataClear()
                                adapter.setData(dataDumy.generateDataDumyListTV())

                            }
                        }
                    }
                }
            }

        })

    }
}
