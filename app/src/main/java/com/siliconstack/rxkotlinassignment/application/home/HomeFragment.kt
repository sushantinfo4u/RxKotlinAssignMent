package com.example.assignment1.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siliconstack.rxkotlinassignment.R
import com.siliconstack.rxkotlinassignment.application.home.HomeViewModelFactory
import com.siliconstack.rxkotlinassignment.application.moviedetails.MovieDetailsFragment
import com.siliconstack.rxkotlinassignment.data.api.ApiService
import com.siliconstack.rxkotlinassignment.data.model.MovieData
import com.siliconstack.rxkotlinassignment.data.repository.MovieRepository
import com.siliconstack.rxkotlinassignment.di.network.NetworkModule
import com.siliconstack.rxkotlinassignment.domain.usecase.MovieUseCase
import javax.inject.Inject

class HomeFragment : Fragment() ,MovieAdapter.OnItemClickListener {


    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter:MovieAdapter
    private var movieList = ArrayList<MovieData>()

//    @Inject
//    val usecase:MovieUseCase<R,R> (null,null)


    private lateinit var recyclerView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView:View =  inflater.inflate(R.layout.home_fragment, container, false)
        initView(rootView)
        return rootView
    }


    private fun initView(rootView:View){

        //val apiService = NetworkModule.
        //val movieRepository = MovieRepository(apiService)
       // val factory = HomeViewModelFactory(movieRepository)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)


        recyclerView = rootView.findViewById(R.id.homeFragment_recyclerMovieList)
        val layoutManager =LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        adapter = MovieAdapter(context,movieList)
        MovieAdapter.onItemClickListener = this
        recyclerView.adapter = adapter

        val data = viewModel.getMovieList()
        data.observe(viewLifecycleOwner, Observer {
            movieList.addAll(it)
            adapter.notifyDataSetChanged()

        })
    }

    override fun onClick(model: MovieData) {
        val fragmentManager:FragmentManager = parentFragmentManager

        val bundle= Bundle()
        bundle.putParcelable("MOVIE",model)

        val details = MovieDetailsFragment()
        details.arguments = bundle

            fragmentManager.beginTransaction()
                .replace(R.id.baseActivity_baseContainer,details)
                .commit()
    }



}
