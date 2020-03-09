package com.ntsmoura.topmovies.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ntsmoura.topmovies.R
import com.ntsmoura.topmovies.activities.DescriptionActivity
import com.ntsmoura.topmovies.utils.HTTPConstants
import com.ntsmoura.topmovies.models.Results

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
        val movie: Results = movieList[position]
        holder.movieTextView.text = movie.title
        Glide.with(context).load(HTTPConstants.IMAGE_BASE + movie.poster_path).into(holder.movieImg)
        holder.cardV.setOnClickListener {
            val intent = Intent(context, DescriptionActivity::class.java).apply {
                putExtra("movie_overview", movie.overview)
                putExtra("movie_banner", movie.poster_path)
            }
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTextView = itemView.findViewById(R.id.textView2) as TextView
        val movieImg = itemView.findViewById(R.id.imageView4) as ImageView
        val cardV = itemView.findViewById(R.id.card_v) as CardView
    }
}