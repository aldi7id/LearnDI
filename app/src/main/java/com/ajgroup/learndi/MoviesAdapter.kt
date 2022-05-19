package com.ajgroup.learndi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ajgroup.learndi.data.Movie

class MoviesAdapter(val listMovies: List<Movie>): RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvTitle = holder.itemView.findViewById<TextView>(R.id.tv_title)
        tvTitle.text = listMovies[position].title
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }
}