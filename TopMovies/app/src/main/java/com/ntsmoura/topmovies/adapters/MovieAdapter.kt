package com.ntsmoura.topmovies.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ntsmoura.topmovies.R
import com.ntsmoura.topmovies.activities.DescriptionActivity
import com.ntsmoura.topmovies.models.Results
import com.ntsmoura.topmovies.utils.HTTPConstants
import kotlinx.android.synthetic.main.movie_layout.view.*

class MovieAdapter(private val context: Context, private val movieList: List<Results>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]
        holder.apply {
            itemView.titleTXT.text = movie.title
            itemView.posterIMG.contentDescription = R.string.poster_content.toString() + movie.title
            Glide.with(context).load(HTTPConstants.IMAGE_BASE + movie.posterPath)
                .into(holder.itemView.posterIMG)
            itemView.moviesCV.setOnClickListener {
                val intent = Intent(context, DescriptionActivity::class.java).apply {
                    putExtra("movieOverview", movie.overview)
                    putExtra("movieBanner", movie.posterPath)
                    putExtra("movieTitle",movie.title)
                }
                context.startActivity(intent)
            }

        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}