package com.hamza.soluations.popularmovieskoin.ui.popularmovies

import android.annotation.SuppressLint
import com.hamza.soluations.popularmovieskoin.R
import com.hamza.soluations.popularmovieskoin.model.Movie
import com.hamza.soluations.popularmovieskoin.service.AppDataManager
import com.hamza.soluations.popularmovieskoin.service.retrofit.CallbackWrapper
import com.hamza.soluations.popularmovieskoin.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class PopularMoviesPresenter(private val dataManager: AppDataManager) : BasePresenter<PopularMoviesContract.View>(),
    PopularMoviesContract.Presenter<PopularMoviesContract.View> {

    @SuppressLint("CheckResult")
    override fun getMovies() {
        if (mvpView?.isNetworkConnected()!!) {
//            mvpView?.showLoading()
            dataManager.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : CallbackWrapper<Movie>(mvpView!!) {

                    override fun onSuccess(t: Movie) {
                        mvpView?.hideLoading()
                        mvpView?.getPopularMovies(t)
                        Timber.d(t.results.toString())
                    }

                    override fun onError(e: Throwable) {
                        super.onError(e)
                        mvpView!!.hideLoading()
                        Timber.d(e.message)
                    }
                })

        } else {
            mvpView?.onError(R.string.error_no_internet_connection)
        }
    }
}

