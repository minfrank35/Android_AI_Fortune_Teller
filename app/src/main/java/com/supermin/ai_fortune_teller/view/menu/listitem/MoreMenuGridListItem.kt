package com.supermin.ai_fortune_teller.view.menu.listitem

import android.content.Context

data class MoreMenuGridListItem(
    val title: String,
    val icon: Int,
    val onClick: (context : Context) -> Unit
)
