package com.example.computec.eltadreb.ui.base

import com.androidnetworking.error.ANError
import com.hamza.soluations.popularmovieskoin.ui.base.MvpView

interface MvpPresenter<V : MvpView> {

    fun onAttach(mvpView: V)

    fun onDetach()

    fun handleApiError(error: ANError?)

    fun setUserAsLoggedOut()
}
