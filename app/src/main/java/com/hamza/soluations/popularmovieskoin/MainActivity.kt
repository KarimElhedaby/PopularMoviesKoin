package com.hamza.soluations.popularmovieskoin

import android.os.Bundle
import com.hamza.soluations.popularmovieskoin.ui.base.BaseActivity
import com.hamza.soluations.popularmovieskoin.ui.popularmovies.Popular_MoviesFragment
import com.hamza.soluations.popularmovieskoin.utils.replaceFragmentToActivity

class MainActivity : BaseActivity() {
    override fun getActivityView(): Int =R.layout.activity_main
    override fun afterInflation(savedInstance: Bundle?) {

    replaceFragmentToActivity(Popular_MoviesFragment.newInstance() , false)    }

}
