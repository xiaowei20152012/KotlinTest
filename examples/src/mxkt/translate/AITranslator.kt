package mxkt.translate

abstract class AITranslator {
    val formData : HashMap<String,String> = HashMap()

    abstract fun setFormData(from: LanguageEnum, to: LanguageEnum, text: String)

    abstract fun query(): String

}