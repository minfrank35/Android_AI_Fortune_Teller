package com.supermin.ai_fortune_teller.api.res

data class RESChatgpt(
    val id: String,
    val `object`: String,
    val created: Long,
    val model: String,
    val choices: List<RESChoice>,
    val usage: RESUsage
)

data class RESChoice(
    val index: Int,
    val message: RESMessage,
    val finish_reason: String
)

data class RESMessage(
    val role: String,
    val content: String
)

data class RESUsage(
    val prompt_tokens: Int,
    val completion_tokens: Int,
    val total_tokens: Int
)