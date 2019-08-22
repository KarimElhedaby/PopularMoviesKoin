package com.hamza.soluations.popularmovieskoin.ui.viewposter;

import android.os.Build
import android.os.Bundle
import android.support.transition.ChangeBounds
import android.transition.TransitionInflater
import android.view.View
import com.example.computec.eltadreb.utils.loadImage
import com.hamza.soluations.popularmovieskoin.R
import com.hamza.soluations.popularmovieskoin.ui.details.MovieDetailsFragment
import com.hamza.solutions.kolo.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_viewposter.*
import org.koin.android.ext.android.get

class ViewPosterFragment : BaseFragment(), ViewPosterContract.View {

    private lateinit var presenter: ViewPosterPresenter

    override fun getFragmentView(): Int = R.layout.fragment_viewposter

    override fun setUp(view: View?) {
        presenter = get()
        presenter.onAttach(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition =
                TransitionInflater.from(context).inflateTransition(android.R.transition.move);
            sharedElementEnterTransition = ChangeBounds().apply {
                duration = 500
            }

            viewPosterIV.loadImage(arguments?.getString(ARGUMENT_MOVIE_POSTER))
        }
    }

    companion object {
        private val ARGUMENT_MOVIE_POSTER = "ARGUMENT_MOVIE_POSTER"
        fun newInstance(posterUrl: String): ViewPosterFragment {
            val fragment = ViewPosterFragment()
            val bundle = Bundle()
            bundle.putString(ARGUMENT_MOVIE_POSTER, posterUrl)
            fragment.arguments = bundle
            return fragment
        }
    }
}