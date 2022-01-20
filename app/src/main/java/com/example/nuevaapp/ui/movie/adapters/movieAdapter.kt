package com.example.nuevaapp.ui.movie.adapters
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nuevaapp.core.BaseViewHolder
import com.example.nuevaapp.data.model.Movie

import com.example.nuevaapp.databinding.MovieItemBinding

class movieAdapter (
    private val movieList: List<Movie>,
    private val itemClickListener : OnMovieListener
        ): RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnMovieListener {
        fun OnMovieClick(movie: Movie)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = MoviesViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.adapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener
            itemClickListener.OnMovieClick(movieList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MoviesViewHolder -> holder.bind(movieList[position])
        }
    }

    private inner class MoviesViewHolder(val binding : MovieItemBinding, val context : Context) : BaseViewHolder<Movie>(binding.root){
        override fun bind(item: Movie) {
            Glide.with(context).load("https://image.tmdb.org/t/p/w500${item.poster_path}")
        }

    }
}
