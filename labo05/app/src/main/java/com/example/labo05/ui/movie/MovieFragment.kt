package com.example.labo05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.labo05.R
import com.example.labo05.databinding.FragmentBillboardBinding
import com.example.labo05.databinding.FragmentMovieBinding
import com.example.labo05.databinding.FragmentNewMovieBinding
import com.example.labo05.ui.movie.viewmodel.MovieViewModel

class MovieFragment : Fragment() {

    private val movieViewModel : MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()

    }

    private fun setViewModel(){
        binding.viewmodel = movieViewModel
    }

}