package com.supermin.ai_fortune_teller.domain.repository

import android.util.Log
import com.android.example.saa_navigation_compose.domain.repository.ChatGptRepository
import com.android.example.saa_navigation_compose.domain.repository.LoginRepository
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.supermin.ai_fortune_teller.api.req.REQChatGPT
import com.supermin.ai_fortune_teller.datasource.ChatGptRemoteDataSource
import com.supermin.ai_fortune_teller.uiState.HomeUIState
import com.supermin.ai_fortune_teller.uiState.LoginUIState
import com.supermin.ai_fortune_teller.view.menu.homeUiDO.CardUiItem


class ChatGptRepositoryImpl(
    private val chatGptRemoteDataSource : ChatGptRemoteDataSource
) : ChatGptRepository {
    override suspend fun getChatGptTarotAnswer(reqChatGPT : REQChatGPT) : HomeUIState {
        try {
            val req = reqChatGPT
            val res = chatGptRemoteDataSource.getChatGptTarotAnswer(req)

            if (!res.isSuccessful) {
                return HomeUIState.Error("오류", "res is not 200~300")
            }

            if (res.body() == null) {
                return HomeUIState.Error("오류", "res body가 null 입니다.")
            }


            val i = res.body()!!.choices[0]
            Log.e("minfrank", i.message.content.toString())
            val jsonObject = JsonParser.parseString(i.message.content).asJsonObject
            val pastCardName = jsonObject.get("past_card_name").asString
            val pastCardUrl = jsonObject.get("past_card_url").asString
            val pastCardDirection = jsonObject.get("past_card_direction").asString
            val pastCardMeaning = jsonObject.get("past_card_meaning").asString
            val pastCardItem = CardUiItem(cardType = "PAST", cardName = pastCardName, imageUrl = pastCardUrl, cardDirection = pastCardDirection, cardMeaning = pastCardMeaning)

// Present Card
            val presentCardName = jsonObject.get("present_card_name").asString
            val presentCardUrl = jsonObject.get("present_card_url").asString
            val presentCardDirection = jsonObject.get("present_card_direction").asString
            val presentCardMeaning = jsonObject.get("present_card_meaning").asString
            val presentCardItem = CardUiItem(cardType = "PRESENT", cardName = presentCardName, imageUrl = presentCardUrl, cardDirection = presentCardDirection, cardMeaning = presentCardMeaning)

// Future Card
            val futureCardName = jsonObject.get("future_card_name").asString
            val futureCardUrl = jsonObject.get("future_card_url").asString
            val futureCardDirection = jsonObject.get("future_card_direction").asString
            val futureCardMeaning = jsonObject.get("future_card_meaning").asString
            val futureCardItem = CardUiItem(cardType = "FUTURE", cardName = futureCardName, imageUrl = futureCardUrl, cardDirection = futureCardDirection, cardMeaning = futureCardMeaning)

            // Other
            val result = jsonObject.get("result").asString


            return HomeUIState.Loaded(pastCardItem = pastCardItem, presentCardItem = presentCardItem, futureCardItem = futureCardItem, result = result)
        } catch (e: Exception) {
            return HomeUIState.Error("오류", "런타임 오류가 발생하였습니다.")
        }
    }
}