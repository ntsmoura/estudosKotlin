package com.example.topmovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movie_layout.*
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.movie_layout.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* var view = window.decorView
        view.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.background))*/
        recyclerV.apply {
            //Seta o layout do recycler
            layoutManager = GridLayoutManager(this@MainActivity,2)
            val movies = ArrayList<Movie>()
            movies.add(Movie("a","Batman"))
            movies.add(Movie("b","Pokemon"))
            movies.add(Movie("c","Cory na Casa Branca"))
            movies.add(Movie("c","Cory na Casa Branca"))
            movies.add(Movie("c","Cory na Casa Branca"))
            movies.add(Movie("c","Cory na Casa Branca"))
            movies.add(Movie("c","Cory na Casa Branca"))
            movies.add(Movie("c","Cory na Casa Branca"))
            movies.add(Movie("c","Cory na Casa Branca"))
            movies.add(Movie("c","Cory na Casa Branca"))

            adapter = MovieAdapter(movies)

        }


    }

    fun movieInfo(view: View){
        view.textView2.text = "Mudou"
    }


}
