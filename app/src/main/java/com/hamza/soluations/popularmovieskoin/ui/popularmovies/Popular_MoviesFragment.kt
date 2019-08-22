package com.hamza.soluations.popularmovieskoin.ui.popularmovies

import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.example.computec.eltadreb.utils.ViewUtils
import com.hamza.soluations.popularmovieskoin.R
import com.hamza.soluations.popularmovieskoin.model.Movie
import com.hamza.soluations.popularmovieskoin.model.Result
import com.hamza.soluations.popularmovieskoin.ui.details.MovieDetailsFragment
import com.hamza.soluations.popularmovieskoin.utils.replaceFragmentToActivity
import com.hamza.solutions.kolo.utils.GridSpacingItemDecoration
import com.hamza.solutions.kolo.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_popularmovies.*
import org.koin.android.ext.android.get
import timber.log.Timber

class Popular_MoviesFragment : BaseFragment(), PopularMoviesContract.View, MovieAdapter.IndecatorInterface {

    lateinit var homePresenter: PopularMoviesPresenter

    override fun getFragmentView(): Int = R.layout.fragment_popularmovies

    override fun setUp(view: View?) {
        homePresenter = get()
        homePresenter.onAttach(this)
        homePresenter.getMovies()
    }

    override fun getPopularMovies(Movies: Movie) {
        Timber.d(Movies.toString())
        popularRV.layoutManager = GridLayoutManager(context, 2)
        popularRV.addItemDecoration(
            GridSpacingItemDecoration(1, ViewUtils.dpToPx(8F), true, 0)
        )
        popularRV.adapter = context?.let { MovieAdapter(Movies.results, R.layout.item_movie, this) }
    }

    override fun onMovieItemClickListener(result: Result) {
        baseActivity?.replaceFragmentToActivity(MovieDetailsFragment.newInstance(result), true)
    }

    companion object {
        fun newInstance(): Popular_MoviesFragment {
            val fragment = Popular_MoviesFragment()
            return fragment
        }
    }
}
