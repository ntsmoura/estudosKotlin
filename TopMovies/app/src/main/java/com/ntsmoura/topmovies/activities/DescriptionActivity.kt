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
        val description: String
        val banner: String
        val title: String
        with(intent) {
            description = getStringExtra("movieOverview")
            banner = getStringExtra("movieBanner")
            title = getStringExtra("movieTitle")
        }
        Glide.with(this).load(HTTPConstants.IMAGE_BASE + banner).into(bannerIMG)
        overviewTXT.text = description
        bannerIMG.contentDescription = applicationContext.getString(R.string.poster_content, title)
    }
}
