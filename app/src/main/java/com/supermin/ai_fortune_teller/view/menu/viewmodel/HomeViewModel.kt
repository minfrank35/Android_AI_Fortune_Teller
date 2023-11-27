package com.supermin.ai_fortune_teller.view.menu.viewmodel

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.saa_navigation_compose.domain.repository.ChatGptRepository
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.supermin.ai_fortune_teller.api.ApiClient
import com.supermin.ai_fortune_teller.api.req.REQChatGPT
import com.supermin.ai_fortune_teller.api.req.REQChatGPTMessage
import com.supermin.ai_fortune_teller.const.CHAT_GPT_TAROT_PROMPT
import com.supermin.ai_fortune_teller.datasource.ChatGptRemoteDataSource
import com.supermin.ai_fortune_teller.datasource.ChatGptRemoteDataSourceImpl
import com.supermin.ai_fortune_teller.domain.repository.ChatGptRepositoryImpl
import com.supermin.ai_fortune_teller.uiState.HomeUIState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {
    private var apiClient: ApiClient = ApiClient()
    private var chatGptRemoteDataSource: ChatGptRemoteDataSource = ChatGptRemoteDataSourceImpl(apiClient)
    private var chatGptRepository: ChatGptRepository = ChatGptRepositoryImpl(chatGptRemoteDataSource)
    private var _homeUIState: MutableLiveData<HomeUIState> = MutableLiveData(HomeUIState.Normal)
    val homeUIState: LiveData<HomeUIState> = _homeUIState
    var question by mutableStateOf("")

    fun callChatgpt(question : String) {
        _homeUIState.value = HomeUIState.Loading
        Log.i("LoginViewModel", "callChatgpt")

        val gender :String = "남자"
        val age :String= "20"
        val requestioner = age + "살" + gender
        val messages = mutableListOf<REQChatGPTMessage>()
        messages.add(REQChatGPTMessage(role = "user", content = String.format(CHAT_GPT_TAROT_PROMPT, requestioner, question)))

        val reqChatGPT = REQChatGPT(messages = messages)

        viewModelScope.launch {
            delay(1000)
            _homeUIState.value = chatGptRepository.getChatGptTarotAnswer(reqChatGPT)
        }
    }

}