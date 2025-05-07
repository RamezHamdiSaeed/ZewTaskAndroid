package com.example.zewtaskandroid
import android.content.Context
import com.google.gson.Gson
import java.io.IOException

inline fun <reified T> Context.loadJsonAsset(fileName: String): T {
    val json = try {
        assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (e: IOException) {
        throw RuntimeException("Failed to load $fileName from assets.", e)
    }

    return try {
        val type = object : com.google.gson.reflect.TypeToken<T>() {}.type
        Gson().fromJson<T>(json, type)
    } catch (e: Exception) {
        throw RuntimeException("Failed to decode $fileName from assets.", e)
    }
}