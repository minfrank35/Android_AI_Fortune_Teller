package com.supermin.ai_fortune_teller.datasource

import android.util.Log
import com.supermin.ai_fortune_teller.api.ApiClient
import com.supermin.ai_fortune_teller.api.req.REQChatGPT
import com.supermin.ai_fortune_teller.api.res.RESChatgpt
import retrofit2.Response

class ChatGptRemoteDataSourceImpl(val apiClient: ApiClient) : ChatGptRemoteDataSource {
    override suspend fun getChatGptTarotAnswer(req: REQChatGPT): Response<RESChatgpt> {
        return apiClient.createChatGpt().getChatGptTarotAnswer(req)
    }
}