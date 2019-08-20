package com.hamza.soluations.popularmovieskoin.service.retrofit

import com.hamza.soluations.popularmovieskoin.ui.base.MvpView
import com.google.gson.Gson
import com.hamza.soluations.popularmovieskoin.service.retrofit.model.ErrorSingelMessageResponse
import io.reactivex.observers.DisposableObserver
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.lang.ref.WeakReference

abstract class CallbackWrapper<T : Any>(view: MvpView) : DisposableObserver<T>() {

    private val weakReference: WeakReference<MvpView> = WeakReference(view)

    protected abstract fun onSuccess(t: T)

    override fun onNext(t: T) {
        val view = weakReference.get()
        if (view != null)
            onSuccess(t)
    }

    override fun onError(e: Throwable) {
        val view = weakReference.get()
        view?.hideLoading()
        if (e is HttpException) {
            val responseBody = e.response().errorBody()
            view?.onError(getErrorMessage(responseBody!!))
//            Timber.d(responseBody?.string())
        }
//        else if (e is SocketTimeoutException) {
//            view.onTimeout()
//        } else if (e is IOException) {
//            view.onNetworkError()
//        } else {
//            view.onUnknownError(e.message)
//        }
    }

    override fun onComplete() {

    }

    private fun getErrorMessage(responseBody: ResponseBody): String? {
        return try {
            val error = Gson().fromJson(responseBody.string(), ErrorSingelMessageResponse::class.java)
//            Timber.d(error.toString())
            error.message
        } catch (e: Exception) {
            null
        }

    }
}