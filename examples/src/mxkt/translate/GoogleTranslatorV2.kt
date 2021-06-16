package mxkt.translate

import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import java.net.URLEncoder

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

//        formData.put("client", "gtx");
//        formData.put("sl", "auto");
//        formData.put("tl", "ja");
//        formData.put("dt", "t");
//        formData.put("q", text);

//        formData["anno"] = "3"
//        formData["client"] = "wt_lib"
//        formData["format"] = "html"
//        formData["v"] = "1"
//        formData["sl"] = "auto"
////        formData["hl"] = "ja"
//        formData["tl"] = "ja"
//        formData["sp"] = "nmt"
//        formData["tc"] = "2"
//        formData["sr"] = "1"
//        formData["mode"] = "1"
//        formData["text"] = text

        formData["client"] = "gtx"
        formData["sl"] = "auto"
        formData["tl"] = "ja"
        formData["dt"] = "t"
        formData["q"] = text


        /*
        *
        *
        * StringBuilder sb2 = new StringBuilder("https://translate.googleapis.com/translate_a/t?anno=3&client=wt_lib&format=html&v=1&key&logld=vTE_20200210_00&sl=auto&hl=zh-CN&sp=nmt&tc=2&sr=1&mode=1");
        sb2.append("&tk=" + obj);
        sb2.append("&tl=" + str);
        k.d(sb2, "StringBuilder(GOOGLE_MUL…    .append(\"&tl=$toLan\")");
        * */
    }

    override fun query(): String {
        val url = Util.getUrlWithQuery(Util.googleBaseUrl1, formData)
//        val body: RequestBody = text.toRequestBody(Util.JSON)
        val request: Request = Request.Builder()
                .url(url)
                .addHeader("User-Agent", Util.USER_AGENT)
//                .post(body)
                .get()
                .build()
       ;
        val call: Call =  Util.client.newBuilder().addInterceptor(HttpLogInterceptor()).build().newCall(request)
        val response : Response = call.execute()
        val responseBody : ResponseBody? = response.body

        return responseBody?.byteString().toString()
    }


}