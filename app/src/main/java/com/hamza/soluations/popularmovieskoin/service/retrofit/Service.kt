package com.hamza.soluations.popularmovieskoin.service.retrofit

import com.hamza.soluations.popularmovieskoin.model.Movie
import io.reactivex.Observable
import retrofit2.http.GET

interface Service {

    @GET("popular")
    fun getPopularMovies(): Observable<Movie>

}