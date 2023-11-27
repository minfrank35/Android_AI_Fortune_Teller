package com.supermin.ai_fortune_teller.domain.repository

import com.android.example.saa_navigation_compose.datasource.AIFortuneRemoteDataSource
import com.android.example.saa_navigation_compose.domain.repository.LoginRepository
import com.supermin.ai_fortune_teller.api.req.REQLogin
import com.supermin.ai_fortune_teller.uiState.LoginUIState


class LoginRepositoryImpl(
    private val loginRemoteDataSource : AIFortuneRemoteDataSource
) : LoginRepository {
    override suspend fun getLoginData(reqLogin : REQLogin) : LoginUIState {
        try {
            //공통 start
            val req = reqLogin
            val res = loginRemoteDataSource.getMOBL_0001(req)

            if (!res.isSuccessful) {
                return LoginUIState.Error("오류", "res is not 200~300")
            }

            if (res.body() == null) {
                return LoginUIState.Error("오류", "res body가 null 입니다.")
            }

            if (res.body()!!.respCd != "0000") {
                return LoginUIState.Error(res.body()!!.respCd, res.body()!!.respMsg)
            }
            //실패
            /*else if (res.body()!!.RESP_DATA.respCd == "5510") {
                return LoginUIState.Error("", res.body()!!.RSLT_MSG)
            } else {
                return LoginUIState.Error(
                    "응답코드[" + res.body()!!.RESP_DATA.respCd + "]",
                    res.body()!!.RESP_DATA.respMsg
                )
            }*/
            return LoginUIState.Loaded
        } catch (e: Exception) {
            return LoginUIState.Error("오류", "런타임 오류가 발생하였습니다.")
        }
    }
}