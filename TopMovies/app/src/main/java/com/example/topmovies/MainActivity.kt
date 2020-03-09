package com.example.topmovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.movie_layout.view.*
import retrofit2.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* var view = window.decorView
        view.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.background))*/
        getData()

    }

    fun movieInfo(view: View){
        view.textView2.text = "Mudou"
    }

    private fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://api.themoviedb.org")

        val endpoint = retrofitClient.create(TmdbInterface::class.java)
        val call = endpoint.getMovies()

        call.enqueue(object : Callback<PopularMovies>{
                override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                    if (response.isSuccessful){
                        recyclerV.apply {
                            //Seta o layout do recycler
                            layoutManager = GridLayoutManager(this@MainActivity,2)

                            //adapter = MovieAdapter(movies)
                            adapter = MovieAdapter(response.body()!!.results)

                        }
                    }
                }
                    override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

