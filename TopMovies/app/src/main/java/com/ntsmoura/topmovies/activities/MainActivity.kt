package com.ntsmoura.topmovies.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ntsmoura.topmovies.adapters.MovieAdapter
import com.ntsmoura.topmovies.R
import com.ntsmoura.topmovies.utils.TmdbInterface
import com.ntsmoura.topmovies.utils.HTTPConstants
import com.ntsmoura.topmovies.models.PopularMovies
import com.ntsmoura.topmovies.models.Results
import com.ntsmoura.topmovies.utils.NetworkUtils
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: MovieAdapter
    private var listMovies: ArrayList<Results> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = recyclerV
        recyclerAdapter =
            MovieAdapter(this, listMovies)
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        recyclerView.adapter = recyclerAdapter

        getData()

    }


    private fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance(HTTPConstants.MOVIE_BASE_URL)

        val endpoint = retrofitClient.create(TmdbInterface::class.java)
        val call = endpoint.getMovies(HTTPConstants.API_KEY, HTTPConstants.LANGUAGE)
        call.enqueue(object : Callback<PopularMovies> {
            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                if (response.isSuccessful) {
                    listMovies.addAll(response.body()!!.results)
                    recyclerV.adapter!!.notifyItemRangeInserted(
                        recyclerAdapter.itemCount,
                        listMovies.size
                    )
                }
            }

            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Não foi possível encontrar filmes, verifique a conexão!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}

