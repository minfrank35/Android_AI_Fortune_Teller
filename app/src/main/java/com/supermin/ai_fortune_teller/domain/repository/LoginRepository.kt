package com.android.example.saa_navigation_compose.domain.repository

import com.supermin.ai_fortune_teller.api.req.REQLogin
import com.supermin.ai_fortune_teller.uiState.LoginUIState

interface LoginRepository {
    suspend fun getLoginData(reqLogin : REQLogin) : LoginUIState
}