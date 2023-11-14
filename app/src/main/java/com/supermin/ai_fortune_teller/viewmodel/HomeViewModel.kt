package com.supermin.ai_fortune_teller.viewmodel

import android.text.TextUtils
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {
    /*private var apiClient: ApiClient = ApiClient()
    private var loginDataSource: SerpRemoteDataSource = SerpRemoteDataSourceImpl(apiClient)
    private var loginRepository: LoginRepository = LoginRepositoryImpl(loginDataSource)
    private var _loginUIState: MutableLiveData<LoginUIState> = MutableLiveData(LoginUIState.Normal)

    val loginUIState: LiveData<LoginUIState> = _loginUIState

    var id by mutableStateOf("") //two way binding
    var pwd by mutableStateOf("")//two way binding
    private var _bizNo: MutableLiveData<String> = MutableLiveData("")//two way binding
    val bizNo: LiveData<String> = _bizNo//two way binding

    fun callLogin() {
        _loginUIState.value = LoginUIState.Loading
        Log.i("LoginViewModel", "callLogin")
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(pwd)) {
            _loginUIState.value = LoginUIState.Error("오류","아이디 또는 비밀번호를 입력해주세요.")
            return
        }

        val reqLogin = REQLogin(
            userId = id.trim(),
            pwd = pwd.trim()
        )

        viewModelScope.launch {
            delay(1000)//TODO :: It is just Test Code, You can get rid of this delay function
            _loginUIState.value = loginRepository.getLoginData(reqLogin)
        }

    }

    fun callLogin2() {
        _loginUIState.value = LoginUIState.Loading

        Log.i("LoginViewModel", "callLogin2")

        val reqLogin2 = REQLogin2(
            APP_IRON_ADATA = "",
            APP_IRON_SID = "",
            APP_VER = "1.4.1",
            APP_ID = "SERP",

            USER_ID = id.trim(),
            PWD = pwd.trim(),
            BIZ_NO = bizNo.value!!.trim(),
            APP_OS = "android",
        )

        viewModelScope.launch {
            delay(1000)
            _loginUIState.value = loginRepository.getLoginData2(reqLogin2)
        }

    }

    fun onClickCommListPopupItem(item : ListViewItem) {
        _bizNo.value = item.detail
        callLogin2()
    }*/
}