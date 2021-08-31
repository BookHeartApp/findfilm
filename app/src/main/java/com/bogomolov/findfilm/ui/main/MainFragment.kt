package com.bogomolov.findfilm.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.bogomolov.findfilm.R
import com.bogomolov.findfilm.databinding.FragmentMainBinding
import com.bogomolov.findfilm.ui.adapters.MoviePagerAdapter
import com.bogomolov.findfilm.ui.allMovies.AllMoviesFragment
import com.bogomolov.findfilm.ui.search.SearchFragment
import com.bogomolov.findfilm.utils.FragmentViewBinding

class MainFragment : FragmentViewBinding<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private lateinit var pagerAdapter: MoviePagerAdapter

    private lateinit var fragmentList: MutableList<Pair<Fragment, String>>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createFragmentList()
        bindPagerAdapter()
    }

    private fun createFragmentList() {
        fragmentList = mutableListOf(
            SearchFragment() to getString(R.string.movie_search),
            AllMoviesFragment() to getString(R.string.all_movies)
        )
    }

    private fun bindPagerAdapter() {
        pagerAdapter = MoviePagerAdapter(this, fragmentList)
        binder.pager.adapter = pagerAdapter
        TabLayoutMediator(binder.tabLayout, binder.pager) { tab, i ->
            tab.text = fragmentList[i].second
        }.attach()
    }
}