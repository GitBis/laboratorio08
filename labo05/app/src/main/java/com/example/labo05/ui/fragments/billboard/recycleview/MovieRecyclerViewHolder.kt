package com.example.labo05.ui.fragments.billboard.recycleview

import androidx.recyclerview.widget.RecyclerView
import com.example.labo05.data.model.MovieModel
import com.example.labo05.databinding.MovieItemBinding
//import com.example.labo05.generated.callback.OnClickListener

class MovieRecyclerViewHolder (private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(movie: MovieModel, clickListener: (MovieModel)->Unit){
        binding.titleTextView.text = movie.name
        binding.qualificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener{
            clickListener(movie)
        }
    }
}
