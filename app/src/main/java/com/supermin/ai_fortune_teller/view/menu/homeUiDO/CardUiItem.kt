package com.supermin.ai_fortune_teller.view.menu.homeUiDO

data class CardUiItem(
    val imageUrl : String,
    val cardName : String,
    val cardDirection : String,
    val cardType : String, // PAST, PRESENT, FUTURE
    val cardMeaning : String,
)
