package com.siliconstack.rxkotlinassignment.application.moviedetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.siliconstack.rxkotlinassignment.R
import com.siliconstack.rxkotlinassignment.data.model.MovieData
import kotlinx.android.synthetic.main.movie_details_fragment.*
import kotlinx.android.synthetic.main.movie_details_fragment.view.*


class MovieDetailsFragment : Fragment() {

    private lateinit var model: MovieData


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView: View = inflater.inflate(R.layout.movie_details_fragment, container, false)
        initView(rootView)
        return rootView
    }

    private fun initView(rootView: View) {

        arguments?.let {
            model = it.getParcelable("MOVIE")!!


            Log.e("TAG", "id-" + model.id)

            Glide.with(context!!).load(model.poster).into(rootView.movieDetails_ivPoster)
            rootView.movieDetails_tvId.text = "${model.id}"
            rootView.movieDetails_tvTitle.text = "${model.title}"
            rootView.movieDetails_tvYear.text = "${model.year}"
            rootView.movieDetails_tvGenre.text = "${model.genre}"

        }


    }
}
