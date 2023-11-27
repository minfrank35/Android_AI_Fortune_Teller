package com.supermin.ai_fortune_teller.datasource

import com.android.example.saa_navigation_compose.datasource.AIFortuneRemoteDataSource
import com.supermin.ai_fortune_teller.api.ApiClient
import com.supermin.ai_fortune_teller.api.req.REQLogin
import com.supermin.ai_fortune_teller.api.res.RESLogin
import retrofit2.Response

class AIFortuneRemoteDataSourceImpl(private val apiClient: ApiClient) : AIFortuneRemoteDataSource {
    override suspend fun getMOBL_0001(req: REQLogin): Response<RESLogin> {
        return apiClient.create().getLoginData(req)
    }
}