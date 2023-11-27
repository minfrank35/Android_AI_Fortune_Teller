package com.supermin.ai_fortune_teller.view.setting

data class SettingRowUiItem(
    var imageResourceId: Int,
    var title: String,
    var isButton: Boolean = false,
    var onClickButton: (isClicked: Boolean) -> Unit = {}
)
