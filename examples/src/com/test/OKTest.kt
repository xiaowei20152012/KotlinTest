package com.test

import okhttp3.OkHttpClient
import okhttp3.Request


fun main() {
    val okHttpClient = OkHttpClient()
    val okHttpClientCustom = OkHttpClient.Builder().build()

    val request = Request.Builder().get().url("https://www.kotlincn.net/docs/reference/keyword-reference.html").build()
    val response = okHttpClient.newCall(request).execute()

    System.out.println(response.message)
}