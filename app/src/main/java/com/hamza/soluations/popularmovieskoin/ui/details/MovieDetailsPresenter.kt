package com.hamza.soluations.popularmovieskoin.ui.details;

import com.hamza.soluations.popularmovieskoin.ui.base.BasePresenter
import com.hamza.soluations.popularmovieskoin.service.AppDataManager

class MovieDetailsPresenter(private val dataManager: AppDataManager): BasePresenter<MovieDetailsContract.View>(), MovieDetailsContract.Presenter<MovieDetailsContract.View> {

}