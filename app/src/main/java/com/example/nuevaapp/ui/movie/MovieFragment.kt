package com.example.nuevaapp.ui.movie


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.example.nuevaapp.R
import com.example.nuevaapp.core.Resource.*
import com.example.nuevaapp.data.local.AppDataBase
import com.example.nuevaapp.data.local.LocalDataSource
import com.example.nuevaapp.data.model.Movie
import com.example.nuevaapp.data.remote.RemoteMovieDataSource
import com.example.nuevaapp.databinding.FragmentMovieBinding
import com.example.nuevaapp.presentation.movieViewModel
import com.example.nuevaapp.presentation.movieViewModelFactory
import com.example.nuevaapp.repository.MovieRepositoryImpl
import com.example.nuevaapp.repository.RetroFitClient
import com.example.nuevaapp.ui.movie.adapters.movieAdapter
import com.example.nuevaapp.ui.movie.concat.PopularConcatAdapter
import com.example.nuevaapp.ui.movie.concat.TopRatedConcatAdapter
import com.example.nuevaapp.ui.movie.concat.UpComingConcatAdapter
import kotlinx.android.synthetic.main.upcoming_movie_row.*
import java.util.*


class MovieFragment : Fragment(R.layout.fragment_movie), movieAdapter.OnMovieListener {//OnMovieListener es la interfaz de MovieAdapter, por eso la traemos para qeu funcione el this de los adaptadores

    private lateinit var binding: FragmentMovieBinding
    private val ViewModel by viewModels<movieViewModel> {
        movieViewModelFactory(
            MovieRepositoryImpl(
                RemoteMovieDataSource((RetroFitClient.webservice)),
               LocalDataSource(AppDataBase.getDataBase(requireContext().movieDao()))
            )
        )
    }
    private lateinit var concatAdapter : ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)
        concatAdapter = ConcatAdapter()

        ViewModel.fetchMainScreenMovie()
            .observe(viewLifecycleOwner, androidx.lifecycle.Observer { result ->
                when (result) {
                    is Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is Success -> {
                        binding.progressBar.visibility = View.GONE
                        concatAdapter.apply{
                            addAdapter(0, UpComingConcatAdapter(movieAdapter(result.data.first.results, this@MovieFragment))
                            )
                            addAdapter(1, TopRatedConcatAdapter(movieAdapter(result.data.second.results, this@MovieFragment)))
                            addAdapter(2,PopularConcatAdapter(movieAdapter(result.data.third.results, this@MovieFragment)))
                        }
                        binding.rvMovie.adapter = concatAdapter
                    }
                    is Failure -> {
                        Log.d("Error", "$result.exception")
                    }
                }
            })
    }

    override fun OnMovieClick(movie: Movie) {
        Log.d("Movie", "onMovieClick : $movie")
    }
}


//Investigar sobre como importar la libreria ConcatAdapter que es la gran mayoria de los fallos