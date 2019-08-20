package com.hamza.soluations.popularmovieskoin.ui.popularmovies

import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.hamza.soluations.popularmovieskoin.model.Movie
import com.hamza.soluations.popularmovieskoin.ui.base.MvpView


interface PopularMoviesContract {

    interface View : MvpView {

       fun getPopularMovies(Movies:Movie)

    }
    interface Presenter<V : View> : MvpPresenter<V>{
        fun getMovies()

    }
}