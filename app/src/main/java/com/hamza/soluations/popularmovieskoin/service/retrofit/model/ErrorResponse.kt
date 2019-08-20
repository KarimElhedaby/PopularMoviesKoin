package com.hamza.soluations.popularmovieskoin.service.retrofit.model

import com.google.gson.annotations.SerializedName
import com.hamza.soluations.popularmovieskoin.service.retrofit.model.ErrorItem

data class ErrorResponse(

        @field:SerializedName("success")
        val success: Boolean? = null,

        @field:SerializedName("error")
        val error: List<ErrorItem?>? = null
)

data class ErrorSingelMessageResponse(

        @field:SerializedName("success")
        val success: Boolean? = null,

        @field:SerializedName("message")
         val message: String? = null
)