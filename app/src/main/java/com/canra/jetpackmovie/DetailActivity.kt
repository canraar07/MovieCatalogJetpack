package com.canra.jetpackmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.canra.jetpackmovie.ui.detail.DetailFragment

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val id = intent.extras?.getString("id")
        val type = intent.extras?.getString("type")

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance(
                    id!!,
                    type!!
                    ))
                .commitNow()
        }
    }

}
