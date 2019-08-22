package com.hamza.soluations.popularmovieskoin.ui.viewposter;

import com.hamza.soluations.popularmovieskoin.ui.base.BasePresenter
import com.hamza.soluations.popularmovieskoin.service.AppDataManager

class ViewPosterPresenter(private val dataManager: AppDataManager) : BasePresenter<ViewPosterContract.View>(), ViewPosterContract.Presenter<ViewPosterContract.View> {

}