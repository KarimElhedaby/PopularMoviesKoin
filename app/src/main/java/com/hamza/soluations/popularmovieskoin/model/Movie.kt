package com.hamza.soluations.popularmovieskoin.model

import com.google.gson.annotations.SerializedName

data class Movie(
        @SerializedName("page") var page: Int,
        @SerializedName("total_results") var totalResults: Int,
        @SerializedName("total_pages") var totalPages: Int,
        @SerializedName("results") var results: List<Result>
)