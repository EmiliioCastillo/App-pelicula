package com.example.nuevaapp.ui.movie.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nuevaapp.core.BaseConcatHolder
import com.example.nuevaapp.databinding.TopRatedMoviesBinding
import com.example.nuevaapp.databinding.UpcomingMovieRowBinding
import com.example.nuevaapp.ui.movie.adapters.movieAdapter

class TopRatedConcatAdapter (private val movieAdapter: movieAdapter) :  RecyclerView.Adapter<BaseConcatHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = TopRatedMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when (holder) {
            is ConcatViewHolder -> holder.bind(movieAdapter)
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: TopRatedMoviesBinding) : BaseConcatHolder<movieAdapter>(binding.root) {
        override fun bind(adapter: movieAdapter) {
            binding.rvTopRatedMovies.adapter = adapter
        }
    }
}