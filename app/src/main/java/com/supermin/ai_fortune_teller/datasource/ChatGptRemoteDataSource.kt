package com.supermin.ai_fortune_teller.datasource

import com.supermin.ai_fortune_teller.api.req.REQChatGPT
import com.supermin.ai_fortune_teller.api.req.REQLogin
import com.supermin.ai_fortune_teller.api.res.RESChatgpt
import com.supermin.ai_fortune_teller.api.res.RESLogin
import retrofit2.Response

interface ChatGptRemoteDataSource {
    suspend fun getChatGptTarotAnswer(req: REQChatGPT): Response<RESChatgpt>
}