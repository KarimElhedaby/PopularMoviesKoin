package com.hamza.soluations.popularmovieskoin.utils

import android.support.v4.app.Fragment
import android.support.v4.view.ViewCompat
import android.view.View
import com.hamza.soluations.popularmovieskoin.R
import com.hamza.solutions.kolo.ui.base.BaseFragment
import com.hamza.soluations.popularmovieskoin.ui.base.BaseActivity


fun BaseActivity.replaceFragmentToActivity(fragment: Fragment, isSaved: Boolean = false, transitionView: View? = null) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.container, fragment)
    if (isSaved) transaction.addToBackStack(null)
    transitionView?.let {
        transaction.addSharedElement(it, ViewCompat.getTransitionName(it)!!)
    }
    transaction.commit()
}

fun BaseActivity.addFragmentToActivity(fragment: Fragment, isSaved: Boolean = false) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.add(R.id.container, fragment)
    if (isSaved) transaction.addToBackStack(null)
    transaction.commit()
}

fun BaseFragment.replaceFragment(fragment: Fragment, isSaved: Boolean = false) {
    val transaction = childFragmentManager.beginTransaction()
    transaction.replace(R.id.container, fragment)
    if (isSaved) transaction.addToBackStack(null)
    transaction.commit()
}