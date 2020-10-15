package com.example.assignment1.ui.home


import android.os.Bundle
import android.util.Log
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
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io

class HomeFragment : Fragment(), MovieAdapter.OnItemClickListener {


    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: MovieAdapter
    private var movieList = ArrayList<MovieData>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView: View = inflater.inflate(R.layout.home_fragment, container, false)
        initView(rootView)
        return rootView
    }


    private fun initView(rootView: View) {

        val apiService = ApiService.invoke()
        val movieRepository = MovieRepository(apiService)
        val factory = HomeViewModelFactory(movieRepository)
        viewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)

        recyclerView = rootView.findViewById(R.id.homeFragment_recyclerMovieList)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        adapter = MovieAdapter(context, movieList)
        MovieAdapter.onItemClickListener = this
        recyclerView.adapter = adapter


        //dispose it
        val response = viewModel.observeRxData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                    movieList.addAll(it)
                    adapter.notifyDataSetChanged()

            },{
                Log.e("Error",it.toString())
            })




       // adapter = MovieAdapter(context, movieList)



        //val list1 =

//        val response = viewModel.getData()
//                response.observe(viewLifecycleOwner, Observer {
//                    Log.e("size getting","--"+it.size)
//                })




//        val obs = Observable.fromArray(viewModel.getData())
//            .subscribeOn(io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.e("list size","--"+it.size)
//            },{
//                Log.e("error view","${it.printStackTrace()}")
//            })




//        val data = viewModel.getData()
//            .subscribeOn(io())
//            .subscribe({
//                it.movieData.map {
//                    Log.e("TAG", "" + it.title)
//                    movieList.add(MovieData(it.genre, it.id, it.poster, it.title, it.year))
//                    adapter.notifyDataSetChanged()
//                }
//
//
//            }
//                , {
//                    Log.e("TAG", it.toString())
//                })



//        val data = viewModel.getMovieList()
//        data.observe(viewLifecycleOwner, Observer {
//            movieList.addAll(it)
//            adapter.notifyDataSetChanged()
//
//        })
    }

    override fun onClick(model: MovieData) {
        val fragmentManager: FragmentManager = parentFragmentManager

        val bundle = Bundle()
        bundle.putParcelable("MOVIE", model)

        val details = MovieDetailsFragment()
        details.arguments = bundle

        fragmentManager.beginTransaction()
            .replace(R.id.baseActivity_baseContainer, details)
            .commit()
    }


}
