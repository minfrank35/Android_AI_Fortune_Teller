package com.supermin.ai_fortune_teller.api

import com.supermin.ai_fortune_teller.const.BASE_URL
import com.supermin.ai_fortune_teller.const.CHAT_GPT_API_KEY
import com.supermin.ai_fortune_teller.const.CHAT_GPT_BASE_URL
import com.webcash.serp3_0.data.api.RetrofitInterface
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.CookieHandler
import java.net.CookieManager
import java.net.URI
import java.net.URISyntaxException
import java.util.concurrent.TimeUnit

class ApiClient {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val chatGptokHttpClient : OkHttpClient = OkHttpClient.Builder().run {
        addInterceptor(ChatGptHeaderInterceptor())
//        addInterceptor(CookieInterceptor())
        addInterceptor(loggingInterceptor)
        connectTimeout(30000, TimeUnit.SECONDS)
        readTimeout(30000,TimeUnit.SECONDS)
        writeTimeout(30000,TimeUnit.SECONDS)
    }.build()
    fun create() : RetrofitInterface {
        // 로그 메시지의 포맷을 설정.
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(chatGptokHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)

    }

    fun createChatGpt() : RetrofitInterface {
        // 로그 메시지의 포맷을 설정.
        return Retrofit.Builder()
            .baseUrl(CHAT_GPT_BASE_URL)
            .client(chatGptokHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)
    }
    class ChatGptHeaderInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain) : Response = with(chain) {
            val newRequest = request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer $CHAT_GPT_API_KEY")
                .build()
            proceed(newRequest)
        }
    }

    class CookieInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val requestURL: String = BASE_URL
            if(!chain.request().headers("Set-Cookie").isEmpty()) {
                val cookieStore = (CookieHandler.getDefault() as CookieManager).cookieStore
                var uri: URI? = null
                try {
                    uri = URI(BASE_URL)
                } catch (e: URISyntaxException) {
                    e.printStackTrace()
                }
                val url = uri.toString()

                val cookies = cookieStore[uri]
                for (cookie in cookies) {
                    val setCookie = StringBuilder(cookie.toString())
                        .append("; domain=").append(cookie.domain)
                        .append("; path=").append(cookie.path)
                        .toString()
                    android.webkit.CookieManager.getInstance().setCookie(url, setCookie)
                }
            }
            return chain.proceed(chain.request().newBuilder().addHeader("Cookie", android.webkit.CookieManager.getInstance().getCookie(requestURL)).build())
        }
    }
}