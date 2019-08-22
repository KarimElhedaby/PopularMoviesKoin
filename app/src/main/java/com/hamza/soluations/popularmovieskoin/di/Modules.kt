package com.hamza.soluations.popularmovieskoin.di

import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.hamza.soluations.popularmovieskoin.service.AppDataManager
import com.hamza.soluations.popularmovieskoin.service.retrofit.Constant
import com.hamza.soluations.popularmovieskoin.service.retrofit.Service
import com.hamza.soluations.popularmovieskoin.ui.details.MovieDetailsContract
import com.hamza.soluations.popularmovieskoin.ui.details.MovieDetailsPresenter
import com.hamza.soluations.popularmovieskoin.ui.popularmovies.PopularMoviesPresenter
import com.hamza.soluations.popularmovieskoin.ui.popularmovies.PopularMoviesContract
import com.hamza.soluations.popularmovieskoin.ui.viewposter.ViewPosterContract
import com.hamza.soluations.popularmovieskoin.ui.viewposter.ViewPosterPresenter
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

val applicationModule = module(override = true) {

    single {
        HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger { message ->
                Timber.d("NETWORK: $message")
            }).apply {
            level = HttpLoggingInterceptor.Level.NONE
        }
    }

    single {
        OkHttpClient.Builder()
            .pingInterval(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addNetworkInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .addHeader("api_key", Constant.API_KEY)
                    .build()
                return@addNetworkInterceptor chain.proceed(request)
            }
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(get())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single{
        get<Retrofit>().create(Service::class.java)
    }

    single {
        AppDataManager(
            get()
        )
    }

    single {
        PopularMoviesPresenter(get())
    }
    single {
        ViewPosterPresenter(get())
    }

    factory<PopularMoviesContract.Presenter<PopularMoviesContract.View>> { get() }
    factory<ViewPosterContract.Presenter<ViewPosterContract.View>> { get() }

    single {
        MovieDetailsPresenter(get())
    }
    factory< MovieDetailsContract.Presenter<MovieDetailsContract.View>> { get()}
}