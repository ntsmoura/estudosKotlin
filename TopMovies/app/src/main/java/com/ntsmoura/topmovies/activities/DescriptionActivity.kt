package com.ntsmoura.topmovies.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ntsmoura.topmovies.R
import com.ntsmoura.topmovies.utils.HTTPConstants
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        val description = intent.getStringExtra("movieOverview")
        val banner = intent.getStringExtra("movieBanner")
        val title = intent.getStringExtra("movieTitle")
        Glide.with(this).load(HTTPConstants.IMAGE_BASE + banner).into(bannerIMG)
        overviewTXT.text = description
        bannerIMG.contentDescription = R.string.poster_content.toString() + title
    }
}
