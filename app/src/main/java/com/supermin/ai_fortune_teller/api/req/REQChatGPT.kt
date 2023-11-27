package com.supermin.ai_fortune_teller.api.req

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.supermin.ai_fortune_teller.const.CHAT_GPT_TAROT_PROMPT

data class REQChatGPT(
    val model : String = "gpt-3.5-turbo",
    val messages : List<REQChatGPTMessage>,
)

data class REQChatGPTMessage(
    val role : String = "user",
    val content : String = CHAT_GPT_TAROT_PROMPT,
)