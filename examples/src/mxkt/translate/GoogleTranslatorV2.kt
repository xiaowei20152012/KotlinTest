package mxkt.translate

import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody

class GoogleTranslatorV2 : AITranslator() {
    private lateinit var text : String

    override fun setFormData(from: LanguageEnum, to: LanguageEnum, text: String) {
        this.text = text
        formData.clear()
//        formData["ref"] = "edge"
//        formData["from"] = ""
////        formData["to"] = to.name
//        formData["to"] = "ja"
//        formData["to"] = "Japanese"
        formData.put("client", "gtx");
        formData.put("sl", "en");
        formData.put("tl", "ja");
        formData.put("dt", "t");
        formData.put("q", text);
    }

    override fun query(): String {
        val url = Util.getUrlWithQuery(Util.googleBaseUrl, formData)
//        val body: RequestBody = text.toRequestBody(Util.JSON)
        val request: Request = Request.Builder()
                .url(url)
//                .post(body)
                .get()
                .build()

        val call: Call = Util.client.newCall(request)
        val response : Response = call.execute()
        val responseBody : ResponseBody? = response.body

        return responseBody?.byteString().toString()
    }


}