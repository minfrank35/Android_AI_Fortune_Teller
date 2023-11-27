package com.webcash.serp3_0.data.api


import com.supermin.ai_fortune_teller.api.req.REQChatGPT
import com.supermin.ai_fortune_teller.api.req.REQLogin
import com.supermin.ai_fortune_teller.api.res.RESChatgpt
import com.supermin.ai_fortune_teller.api.res.RESLogin
import com.supermin.ai_fortune_teller.const.CHAT_GPT_CHATTING_URI
import com.supermin.ai_fortune_teller.const.SITE_REQUEST_URI
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitInterface {
    @POST(SITE_REQUEST_URI)
    suspend fun getLoginData(
        @Body req : REQLogin
    ) : Response<RESLogin>

    @POST(CHAT_GPT_CHATTING_URI)
    suspend fun getChatGptTarotAnswer(
        @Body req : REQChatGPT
    ) : Response<RESChatgpt>

}