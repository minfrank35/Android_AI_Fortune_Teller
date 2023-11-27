package com.supermin.ai_fortune_teller.uiState

import com.supermin.ai_fortune_teller.view.menu.homeUiDO.CardUiItem

sealed class HomeUIState() {
    object Loading : HomeUIState()
    object Normal : HomeUIState()
    data class Error(val title: String, val errMsg: String, val onClickButton: () -> Unit = {}) :
        HomeUIState()

    data class Loaded(
        var pastCardItem: CardUiItem,
        var presentCardItem: CardUiItem,
        var futureCardItem: CardUiItem,
        var result: String
    ) : HomeUIState()
}