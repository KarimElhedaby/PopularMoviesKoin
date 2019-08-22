package com.hamza.soluations.popularmovieskoin.ui.details;

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import com.example.computec.eltadreb.utils.loadImage
import com.hamza.soluations.popularmovieskoin.R
import com.hamza.soluations.popularmovieskoin.model.Result
import com.hamza.soluations.popularmovieskoin.service.retrofit.Constant
import com.hamza.soluations.popularmovieskoin.ui.viewposter.ViewPosterFragment
import com.hamza.soluations.popularmovieskoin.utils.replaceFragmentToActivity
import com.hamza.soluations.popularmovieskoin.utils.replaceFragmentToActivityWithSharedElementAnimation
import com.hamza.solutions.kolo.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_moviedetails.*
import org.koin.android.ext.android.get
import android.support.transition.*

class MovieDetailsFragment : BaseFragment(), MovieDetailsContract.View {

    private lateinit var presenter: MovieDetailsPresenter
    lateinit var result: Result
    override fun getFragmentView(): Int = R.layout.fragment_moviedetails

    override fun setUp(view: View?) {
        presenter = get()
        presenter.onAttach(this)

        result = arguments?.getSerializable("ARGUMENT_MOVIE_RESULT") as Result

        background_imageView.loadImage(Constant.Image_URL + result.backdropPath)
        cover_imageView.loadImage(Constant.Image_URL + result.posterPath)
        title_tv.text = result.title
        description_label_tv.text = result.originalTitle
        description_tv.text = result.overview
        vote_average_tv.text = result.voteAverage.toString()
        votes_total_tv.text = result.voteCount.toString()
        release_date_tv.text = result.releaseDate

        cover_imageView.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                sharedElementEnterTransition =
                    TransitionInflater.from(context).inflateTransition(android.R.transition.move);
                sharedElementEnterTransition = ChangeBounds().apply {
                    duration = 500
                }

                baseActivity!!.replaceFragmentToActivityWithSharedElementAnimation(
                    ViewPosterFragment.newInstance(
                        Constant.Image_URL + result.posterPath
                    ), true, cover_imageView
                )

            } else {
                baseActivity!!.replaceFragmentToActivity(
                    ViewPosterFragment.newInstance(Constant.Image_URL + result.posterPath),
                    true
                )
            }
        }
    }

    companion object {
        private val ARGUMENT_MOVIE_RESULT = "ARGUMENT_MOVIE_RESULT"
        fun newInstance(result: Result): MovieDetailsFragment {
            val fragment = MovieDetailsFragment()
            val bundle = Bundle()
            bundle.putSerializable(ARGUMENT_MOVIE_RESULT, result)
            fragment.arguments = bundle
            return fragment
        }
    }
}