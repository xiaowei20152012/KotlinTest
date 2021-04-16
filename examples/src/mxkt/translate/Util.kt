package mxkt.translate

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import java.net.URLEncoder

class Util {
    companion object {
        val client = OkHttpClient()
        const val bingBaseUrl = "https://www.bing.com/translator/api/translate"
        val JSON = "application/json; charset=utf-8".toMediaType()


        fun getUrlWithQuery(url : String, params : Map<String, String>) : String {
            if (params.isNullOrEmpty()) {
                return url
            }
            val builder = StringBuilder(url)
            if (url.contains("?")) {
                builder.append("&")
            } else {
                builder.append("?")
            }
            var index = 0
            for (key in params.keys) {
                val value = params[key];
                if (value.isNullOrEmpty()) {
                    continue
                }
                if (index != 0) {
                    builder.append("&")
                }
                index++
                builder.append(key)
                builder.append("=")
                builder.append(encode(value))
            }
            return builder.toString()
        }

        private fun encode(input : String) : String {
            if (input.isEmpty()) {
                return ""
            }
            return URLEncoder.encode(input, "utf-8")
        }

    }
}