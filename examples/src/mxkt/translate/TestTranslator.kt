package mxkt.translate

import com.google.gson.Gson

fun main() {

//    val translator = BingTranslator()
    val translator = GoogleTranslatorV2()
/*    val text = "[\n" +
            "  \"\",\n" +
            "  \"I won't finish it for you this time.\",\n" +
            "  \"\",\n" +
            "  \"The decision has to be yours.\",\n" +
            "  \"\",\n" +
            "  \"Wait.\",\n" +
            "  \"\",\n" +
            "  \"Who are you?\",\n" +
            "  \"\",\n" +
            "  \"My name is Talon.\",\n" +
            "  \"\",\n" +
            "  \"Come on.\"\n" +
            "]"*/

//    val text = "[\n" +
//            "  \"給我趴在地上，趴下\",\n" +
//            "  \"趴下，不准動\",\n" +
//            "  \"快…\",\n" +
//            "  \"快點…\",\n" +
//            "  \"通通不准動\",\n" +
//            "  \"趴下！\",\n" +
//            "  \"…駕駛紅色速霸陸WRX\",\n" +
//            "  \"玩命再劫\",\n" +
//            "  \"（希利大樓）\"\n" +
//            "]"
//    val text = "[\"\",\"I won\\u0027t finish it for you this time.\",\"\",\"The decision has to be yours.\",\"\"]"
//    val array = ArrayList<String>()
    val builder = StringBuilder()
    for (index in 1..30) {
        builder.append("我很好 \n 我不好 \n 我很棒 $index \n")
        builder.append("\n")
        builder.append(" ")
        builder.append("\n")
    }
    val gson = Gson()
    val text = builder.toString()
//    val text = array.toString()
//    val text = gson.toJson(array)

    println(text)

//    println(array.toString())
//    val begin = "["
//    var middle = StringBuilder()
//    for (index in 1..10) {
//        if (middle.length > 14000) {
//            break
//        }
//        middle.append("I won\\u0027t finish it for you this time.")
//        middle.append(",")
//    }
//    middle.append("I won\\u0027t finish it for you this time.")
//
//    val end = "]"
//
//    val text = begin + middle.toString() + end
    println(text.length)
    translator.setFormData(LanguageEnum.EN, LanguageEnum.JA, text)
    val response = translator.query()
    println(response)

}

internal annotation class ClickType {
    companion object {
        var ITEM_CLICK = 1
        var MENU_CLICK = 2
        var LONG_CLICK = 3
    }
}