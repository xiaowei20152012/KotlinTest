package mxkt.translate

fun main() {

//    val translator = BingTranslator()
    val translator = GoogleTranslatorV2()
    val text = "[\"\",\"I won\\u0027t finish it for you this time.\",\"\",\"The decision has to be yours.\",\"\"]"
    translator.setFormData(LanguageEnum.EN, LanguageEnum.JA, text)
    val response = translator.query()
    println(response)

}