package com.example.nuevaapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.nuevaapp.core.Resource
import com.example.nuevaapp.repository.MovieRepository
import kotlinx.coroutines.Dispatchers

class movieViewModel(private val repo : MovieRepository): ViewModel() {

    fun fetchMainScreenMovie() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(Triple(repo.getUpComingMovies(), repo.getTopRatedMovies(), repo.getPopularMovies())))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}
class movieViewModelFactory(private val repo : MovieRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }
}

