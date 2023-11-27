package com.supermin.ai_fortune_teller.view.setting

import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.saa_navigation_compose.datasource.AIFortuneRemoteDataSource
import com.android.example.saa_navigation_compose.domain.repository.LoginRepository
import com.supermin.ai_fortune_teller.api.ApiClient
import com.supermin.ai_fortune_teller.domain.repository.LoginRepositoryImpl
import com.supermin.ai_fortune_teller.uiState.LoginUIState
import com.supermin.ai_fortune_teller.datasource.AIFortuneRemoteDataSourceImpl
import com.supermin.ai_fortune_teller.R

class SettingViewModel() : ViewModel() {
    private var apiClient: ApiClient = ApiClient()
    private var loginDataSource: AIFortuneRemoteDataSource =
        AIFortuneRemoteDataSourceImpl(apiClient)
    private var loginRepository: LoginRepository = LoginRepositoryImpl(loginDataSource)
    private var _loginUIState: MutableLiveData<LoginUIState> = MutableLiveData(LoginUIState.Normal)

    val loginUIState: LiveData<LoginUIState> = _loginUIState

    val settingList: List<List<SettingRowUiItem>> = mutableStateListOf(
        listOf(
            SettingRowUiItem(
                imageResourceId = R.drawable.alarm,
                "AI Fortune Teller 운세 소식 받기",
                true
            ) {
                if (it) {
                    //TODO :: 알림 받기
                } else {
                    //TODO :: 알림 받지 않기
                }
            },
        ),
        listOf(
            SettingRowUiItem(
                imageResourceId = R.drawable.info,
                "앱 정보",
            )

        ),
        listOf(
            SettingRowUiItem(
                imageResourceId = R.drawable.logout,
                "로그아웃",
            ),
            SettingRowUiItem(
                imageResourceId = R.drawable.trash,
                "계정 삭제",
            )
        )
    )
}