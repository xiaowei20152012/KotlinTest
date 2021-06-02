package mxkt.translate

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import java.net.URLEncoder

class Util {
    companion object {
        val client = OkHttpClient()
        const val USER_AGENT="Mozilla/5.0";//"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36";

        const val bingBaseUrl = "https://www.bing.com/translator/api/translate"
        const val googleBaseUrl = "https://translate.googleapis.com/translate_a/single"
        const val googleBaseUrl1 = "https://translate.googleapis.com/translate_a/t?"
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