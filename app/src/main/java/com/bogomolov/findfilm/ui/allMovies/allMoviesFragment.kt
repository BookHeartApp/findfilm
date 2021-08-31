package com.bogomolov.findfilm.ui.allMovies

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.bogomolov.findfilm.databinding.FragmentAllmoviesBinding
import com.bogomolov.findfilm.ui.adapters.DividerDecorator
import com.bogomolov.findfilm.ui.adapters.MovieAdapter
import com.bogomolov.findfilm.utils.FragmentViewBinding

class AllMoviesFragment :
    FragmentViewBinding<FragmentAllmoviesBinding>(FragmentAllmoviesBinding::inflate) {
    private val allMoviesViewModel: AllMoviesViewModel by viewModels()
    private var _moviesAdapter: MovieAdapter? = null
    private val movieAdapter: MovieAdapter
        get() = _moviesAdapter!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _moviesAdapter = MovieAdapter { adapterPosition ->
            val movieId = movieAdapter.getMovieId(adapterPosition)
            allMoviesViewModel.navigateToMovie(movieId)
        }
    }

    override fun onStart() {
        super.onStart()
        bindUI()
        observeViewModel()
    }

    private fun bindUI() {
        binder.recView.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerDecorator(requireContext()))
        }
    }

    private fun observeViewModel() {
        allMoviesViewModel.apply {
            getAllMoviesFlow.asLiveData().observe(viewLifecycleOwner) { newList ->
                movieAdapter.apply {
                    updateMovieList(newList)
                    notifyDataSetChanged()
                }
            }
            getBrowserEvent.observe(viewLifecycleOwner) { intent ->
                requireContext().startActivity(intent)
            }
        }
    }
}