package com.example.labo05.ui.fragments.billboard.recycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labo05.R
import com.example.labo05.data.model.MovieModel
import com.example.labo05.databinding.FragmentBillboardBinding
import com.example.labo05.ui.fragments.viewmodel.MovieViewModel


class BillboardFragment : Fragment() {


private lateinit var adapter: MovieRecyclerViewAdapter


    private val movieViewModel : MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentBillboardBinding


private fun showSelectedItem(movie: MovieModel){
    movieViewModel.setSelectedMovie(movie)
    findNavController().navigate(R.id.action_billboardFragment3_to_movieFragment)
    }
private fun displayMovies(){
    adapter.setData(movieViewModel.getMovies())
    adapter.notifyDataSetChanged()
}

private fun setRecyclerView(view: View){
    binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

    adapter = MovieRecyclerViewAdapter { selectedMovie ->
        showSelectedItem(selectedMovie)
    }
    binding.recyclerView.adapter = adapter
    displayMovies()
}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.floatingActionButton2.setOnClickListener {
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment3_to_newMovieFragment)
        }

    }




}
