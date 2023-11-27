package com.android.example.saa_navigation_compose.datasource

import com.supermin.ai_fortune_teller.api.req.REQLogin
import com.supermin.ai_fortune_teller.api.res.RESLogin

import retrofit2.Response

interface AIFortuneRemoteDataSource {
    suspend fun getMOBL_0001(req: REQLogin): Response<RESLogin>
}