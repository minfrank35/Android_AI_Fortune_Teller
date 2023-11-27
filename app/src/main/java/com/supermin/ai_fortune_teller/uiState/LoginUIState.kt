package com.supermin.ai_fortune_teller.uiState

sealed class LoginUIState(){
    object Loading : LoginUIState()
    object Normal : LoginUIState()
    data class Error(val title : String, val errMsg : String, val onClickButton : () -> Unit = {}) : LoginUIState()
    object Loaded : LoginUIState()
}