package com.example.topmovies

import android.view.LayoutInflater
import androidx.recyclerview.widget.*
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class MovieAdapter(val movieList: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.movie_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie: Movie = movieList[position]
        holder.movieTextView.text = movie.title
        if(position%2!=0) holder.movieImg.setImageResource(R.mipmap.simp)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val movieTextView = itemView.findViewById(R.id.textView2) as TextView
        val movieImg = itemView.findViewById(R.id.imageView4) as ImageView
    }
}