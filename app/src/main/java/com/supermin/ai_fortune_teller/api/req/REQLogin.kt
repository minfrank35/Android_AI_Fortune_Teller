package com.supermin.ai_fortune_teller.api.req

import com.google.gson.annotations.SerializedName

data class REQLogin(
    @SerializedName("USER_ID")
    val userId : String,
    @SerializedName("PWD")
    val pwd : String
)
