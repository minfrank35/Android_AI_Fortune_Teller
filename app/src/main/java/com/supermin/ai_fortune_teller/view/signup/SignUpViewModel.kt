package com.supermin.ai_fortune_teller.view.signup

import android.text.TextUtils
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.saa_navigation_compose.datasource.AIFortuneRemoteDataSource
import com.android.example.saa_navigation_compose.domain.repository.LoginRepository
import com.supermin.ai_fortune_teller.api.ApiClient
import com.supermin.ai_fortune_teller.domain.repository.LoginRepositoryImpl
import com.supermin.ai_fortune_teller.api.req.REQLogin
import com.supermin.ai_fortune_teller.uiState.LoginUIState
import com.supermin.ai_fortune_teller.datasource.AIFortuneRemoteDataSourceImpl
import kotlinx.coroutines.launch

class SignUpViewModel() : ViewModel() {
    private var apiClient: ApiClient = ApiClient()
    private var loginDataSource: AIFortuneRemoteDataSource = AIFortuneRemoteDataSourceImpl(apiClient)
    private var loginRepository: LoginRepository = LoginRepositoryImpl(loginDataSource)
    private var _loginUIState: MutableLiveData<LoginUIState> = MutableLiveData(LoginUIState.Normal)

    val loginUIState: LiveData<LoginUIState> = _loginUIState

    var email by mutableStateOf("") //two way binding
    var pwd by mutableStateOf("")//two way binding
    var pwdCheck by mutableStateOf("")//two way binding
    var name by mutableStateOf("")//two way binding
    var birthDay by mutableStateOf("")//two way binding
    var gender by mutableStateOf("")//two way binding

    fun callLogin(onLoaded : () -> Unit) {
        _loginUIState.value = LoginUIState.Loading

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pwd)) {
            _loginUIState.value = LoginUIState.Error("오류","아이디 또는 비밀번호를 입력해주세요.")
            return
        }

        val reqLogin = REQLogin(
            userId = email.trim(),
            pwd = pwd.trim()
        )

        viewModelScope.launch {
//            delay(1000)//TODO :: It is just Test Code, You can get rid of this delay function
//            _loginUIState.value = loginRepository.getLoginData(reqLogin)
//            if(_loginUIState.value == LoginUIState.Loaded) {
                onLoaded()
//            }
        }

    }
}