package com.hamza.soluations.popularmovieskoin.service

import com.hamza.soluations.popularmovieskoin.model.Movie
import com.hamza.soluations.popularmovieskoin.service.retrofit.Service
import io.reactivex.Observable

class AppDataManager(private val service: Service ){
//        override fun getPopularMovies(): Observable<Movie> {
//        return App.getService.getPopularMovies()
//    }

    fun getData(): Observable<Movie> {
        return service.getPopularMovies()
    }
}