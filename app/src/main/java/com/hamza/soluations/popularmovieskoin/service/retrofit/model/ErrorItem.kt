package com.hamza.soluations.popularmovieskoin.service.retrofit.model

import com.google.gson.annotations.SerializedName


data class ErrorItem(

        @field:SerializedName("msg")
        val msg: String? = null,

        @field:SerializedName("param")
        val param: String? = null,

        @field:SerializedName("location")
        val location: String? = null,

        @field:SerializedName("value")
        val value: String? = null
)