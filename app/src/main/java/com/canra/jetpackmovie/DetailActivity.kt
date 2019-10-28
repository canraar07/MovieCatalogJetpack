package com.canra.jetpackmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.canra.jetpackmovie.ui.detail.DetailFragment

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val img = intent.extras?.getString("img")
        val title = intent.extras?.getString("title")
        val overview = intent.extras?.getString("overview")
        val release_date = intent.extras?.getString("release_date")
        val vote_average = intent.extras?.getString("vote_average")

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance(
                    img,
                    title,
                    overview,
                    release_date,
                    vote_average
                    ))
                .commitNow()
        }
    }

}
