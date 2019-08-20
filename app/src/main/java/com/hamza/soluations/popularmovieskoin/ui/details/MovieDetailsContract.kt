package com.hamza.soluations.popularmovieskoin.ui.details;

import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.hamza.soluations.popularmovieskoin.ui.base.MvpView

interface MovieDetailsContract {

    interface View : MvpView {

    }

    interface Presenter<V : View> : MvpPresenter<V> {

    }
}