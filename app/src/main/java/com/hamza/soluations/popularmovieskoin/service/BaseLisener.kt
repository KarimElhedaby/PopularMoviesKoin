package com.hamza.soluations.popularmovieskoin.service

interface BaseLisener<T, E> {

    fun onSuccess(data: T)

    fun onFail(error: E)
}
