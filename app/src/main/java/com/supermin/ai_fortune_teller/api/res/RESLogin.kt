package com.supermin.ai_fortune_teller.api.res

import com.google.gson.annotations.SerializedName

data class RESLogin(
    @SerializedName("RESP_CD")
    val respCd : String,
    @SerializedName("RESP_MSG")
    val respMsg : String
)
