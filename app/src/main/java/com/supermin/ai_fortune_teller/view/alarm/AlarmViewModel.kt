package com.supermin.ai_fortune_teller.view.alarm

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class AlarmViewModel() : ViewModel() {
    val alarmList = mutableStateListOf<AlarmUiDO>()

//    private var apiClient: ApiClient = ApiClient()
//    private var loginDataSource: AIFortuneRemoteDataSource = AIFortuneRemoteDataSourceImpl(apiClient)
//    private var loginRepository: LoginRepository = LoginRepositoryImpl(loginDataSource)
//    private var _loginUIState: MutableLiveData<LoginUIState> = MutableLiveData(LoginUIState.Normal)
//
//    val loginUIState: LiveData<LoginUIState> = _loginUIState
//
//    var email by mutableStateOf("") //two way binding
//    var pwd by mutableStateOf("")//two way binding
//    var pwdCheck by mutableStateOf("")//two way binding
//    var name by mutableStateOf("")//two way binding
//    var birthDay by mutableStateOf("")//two way binding
//    var gender by mutableStateOf("")//two way binding
//
//    fun callLogin(onLoaded : () -> Unit) {
//        _loginUIState.value = LoginUIState.Loading
//
//        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pwd)) {
//            _loginUIState.value = LoginUIState.Error("오류","아이디 또는 비밀번호를 입력해주세요.")
//            return
//        }
//
//        val reqLogin = REQLogin(
//            userId = email.trim(),
//            pwd = pwd.trim()
//        )
//
//        viewModelScope.launch {
////            delay(1000)//TODO :: It is just Test Code, You can get rid of this delay function
////            _loginUIState.value = loginRepository.getLoginData(reqLogin)
////            if(_loginUIState.value == LoginUIState.Loaded) {
//                onLoaded()
////            }
//        }
//
//    }
}