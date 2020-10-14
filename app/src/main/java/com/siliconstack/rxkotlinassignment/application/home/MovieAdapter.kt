package com.example.assignment1.ui.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.siliconstack.rxkotlinassignment.R
import com.siliconstack.rxkotlinassignment.data.model.MovieData
import kotlinx.android.synthetic.main.item_home_list.view.*

class MovieAdapter( private val context: Context?,private val list: ArrayList<MovieData>) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    companion object{
       lateinit var onItemClickListener: OnItemClickListener
    }

    override fun getItemCount(): Int = list.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_list, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val model = list[position]
        context?.let {
            holder.setData(context,model)
        }

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var model: MovieData? = null

        init {

            itemView.setOnClickListener(View.OnClickListener {
                model?.let { model ->
                    onItemClickListener.onClick(model)
                }
            })
        }

        fun setData(context:Context?,model: MovieData) {

            itemView.itemView_id.text = "Id: ${model.id}"
            itemView.itemView_title.text = "Title:${model.title}"
            itemView.itemView_year.text = "Year:${model.year}"
            itemView.itemView_genre.text = "Genre:${model.genre}"

            context?.let { Glide.with(it).load(model.poster).into(itemView.itemView_image) }

            this.model = model
        }
    }

    interface OnItemClickListener{
        fun onClick(model : MovieData)
    }

}