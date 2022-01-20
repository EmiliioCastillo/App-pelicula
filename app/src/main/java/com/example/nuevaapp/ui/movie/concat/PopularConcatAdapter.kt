package com.example.nuevaapp.ui.movie.concat

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nuevaapp.core.BaseConcatHolder
import com.example.nuevaapp.databinding.MovieItemBinding
import com.example.nuevaapp.databinding.PopularMoviesRowBinding
import com.example.nuevaapp.ui.movie.adapters.movieAdapter

class PopularConcatAdapter(private val movieAdapter: movieAdapter) :  RecyclerView.Adapter<BaseConcatHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
    val itemBinding = PopularMoviesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(movieAdapter)
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: PopularMoviesRowBinding) : BaseConcatHolder<movieAdapter>(binding.root){
        override fun bind(adapter: movieAdapter) {
            binding.popularMovies.adapter = adapter
        }
    }
}