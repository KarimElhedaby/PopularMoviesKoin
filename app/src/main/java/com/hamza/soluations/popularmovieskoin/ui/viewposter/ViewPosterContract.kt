package com.hamza.soluations.popularmovieskoin.ui.viewposter;

import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.hamza.soluations.popularmovieskoin.ui.base.MvpView

interface ViewPosterContract {

    interface View : MvpView {

    }

    interface Presenter<V : View> : MvpPresenter<V> {

    }
}