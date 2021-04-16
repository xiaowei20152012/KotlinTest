package mxkt.translate

fun main() {

    val bingTranslator = BingTranslator()
    val text = "[\"\",\"I won\\u0027t finish it for you this time.\",\"\",\"The decision has to be yours.\",\"\"]"
    bingTranslator.setFormData(LanguageEnum.EN, LanguageEnum.JA, text)
    val response = bingTranslator.query()
    println(response)

}