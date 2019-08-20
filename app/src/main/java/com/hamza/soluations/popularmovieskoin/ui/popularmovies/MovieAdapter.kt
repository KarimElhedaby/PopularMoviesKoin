package com.hamza.soluations.popularmovieskoin.ui.popularmovies

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.computec.eltadreb.utils.loadImage
import com.hamza.soluations.popularmovieskoin.model.Movie
import com.hamza.soluations.popularmovieskoin.model.Result
import com.hamza.soluations.popularmovieskoin.service.retrofit.Constant
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by karim on 7/13/18.
 */

open class MovieAdapter(var movies: List<Result>, var rowLayout: Int, var movieListener: IndecatorInterface) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    open class MovieViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return MovieViewHolder(view)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        with(holder.itemView) {

            titleTV!!.text = movies[position].title
            posterIV.loadImage(Constant.Image_URL + movies[position].posterPath)
            setOnClickListener {
                movieListener.onMovieItemClickListener(movies[position])

            }
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    interface IndecatorInterface {
        fun onMovieItemClickListener(result: Result)
    }
}