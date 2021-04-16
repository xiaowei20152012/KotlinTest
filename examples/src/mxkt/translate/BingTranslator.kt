package mxkt.translate

import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody

class BingTranslator : AITranslator() {
    private lateinit var text : String

    override fun setFormData(from: LanguageEnum, to: LanguageEnum, text: String) {
        this.text = text
        formData.clear()
        formData["ref"] = "edge"
        formData["from"] = ""
//        formData["to"] = to.name
        formData["to"] = "ja"
//        formData["to"] = "Japanese"
    }

    override fun query(): String {
        val url = Util.getUrlWithQuery(Util.bingBaseUrl, formData)
        val body: RequestBody = text.toRequestBody(Util.JSON)
        val request: Request = Request.Builder()
                .url(url)
                .post(body)
                .build()

        val call: Call = Util.client.newCall(request)
        val response : Response = call.execute()
        val responseBody : ResponseBody? = response.body

        return responseBody?.byteString().toString()
    }


}