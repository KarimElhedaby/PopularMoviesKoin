package com.example.computec.eltadreb.ui.base

import com.hamza.soluations.popularmovieskoin.ui.base.MvpView

interface SubMvpView : MvpView {

    fun onCreate()

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()

    fun attachParentMvpView(mvpView: MvpView)
}
