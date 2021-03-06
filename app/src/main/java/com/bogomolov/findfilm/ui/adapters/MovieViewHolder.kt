package com.bogomolov.findfilm.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bogomolov.findfilm.R
import com.bogomolov.findfilm.data.Movie
import com.bogomolov.findfilm.databinding.ItemMovieBinding

class MovieViewHolder(
    private val binder: ItemMovieBinding,
    onItemClick: (Int) -> Unit
) : RecyclerView.ViewHolder(binder.root) {
    init {
        binder.root.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }

    fun bindMovie(item: Movie) {
        binder.apply {
            textTitle.text = item.movieTitle
            textType.text = item.movieType.type
            textYear.text = item.movieYear
            Glide.with(binder.root)
                .load(item.posterUri)
                .error(R.drawable.no_poster)
                .into(imagePoster)
        }
    }
}