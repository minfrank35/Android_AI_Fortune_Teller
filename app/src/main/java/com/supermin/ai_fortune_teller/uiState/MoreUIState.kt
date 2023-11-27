package com.supermin.ai_fortune_teller.uiState

sealed class MoreUIState(){
    object Loading : MoreUIState()
    object Normal : MoreUIState()
    data class Error(val title : String, val errMsg : String, val onClickButton : () -> Unit = {}) : MoreUIState()
    object Loaded : MoreUIState()
}