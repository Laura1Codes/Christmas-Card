package com.example.christmascard

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.net.URL

suspend fun getJapaneseRandamQuote(): String {
    return withContext(Dispatchers.IO) {
        try {
            val response = URL("https://zenquotes.io/api/random").readText()
            val json = JSONArray(response)
            json.getJSONObject(0).getString("q")
        } catch (e: Exception) {
            "Fall seven times, stand up eight."
        }
    }
}