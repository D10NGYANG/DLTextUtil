package com.d10ng.text.string

/**
 * 利用正则表达式保留字符串
 * @receiver [String]
 * @param reg [Regex]
 * @return [String]
 */
fun String.keep(reg: Regex): String {
    val ls = reg.findAll(this).map { it.value }
    val text = StringBuilder("")
    ls.forEach { text.append(it) }
    return text.toString()
}

/**
 * 利用正则表达式过滤字符串
 * @receiver [String]
 * @param reg [Regex]
 * @return [String]
 */
fun String.filter(reg: Regex): String {
    return reg.replace(this, "")
}

/** 数字正则表达式 */
val numberRegex = "[0-9]+".toRegex()
/** 字母正则表达式 */
val letterRegex = "[a-zA-Z]+".toRegex()
/** 中文正则表达式 */
val chineseRegex = "[\u4E00-\u9FA5]+".toRegex()

/**
 * 判断字符串是否符合身份证规则
 *
 * @receiver [String]
 * @return [Boolean]
 */
fun String.isIdCard(): Boolean = "(^\\d{15}$)|(^\\d{17}([0-9]|X)$)".toRegex().matches(this)

/**
 * 判断字符串是否符合手机号码规则
 *
 * @receiver [String]
 * @return [Boolean]
 */
fun String.isMobileNumber(): Boolean = "^1[1-9]\\d{9}$".toRegex().matches(this)

/**
 * 判断字符串是否符合邮箱规则
 *
 * @receiver [String]
 * @return [Boolean]
 */
fun String.isEmail(): Boolean = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$".toRegex().matches(this)

/**
 * 判断字符串是否只有中英文数字，不包含特殊字符
 *
 * @receiver [String]
 * @return [Boolean]
 */
fun String.isOnlyChEnNum(): Boolean = "[a-zA-Z0-9\u4E00-\u9FA5]+".toRegex().matches(this)

/**
 * 判断字符串是否只有英文数字，不包含特殊字符
 *
 * @receiver [String]
 * @return [Boolean]
 */
fun String.isOnlyEnNum(): Boolean = "[a-zA-Z0-9]+".toRegex().matches(this)

/**
 * 判断字符串是否只有中英文，不包含特殊字符
 *
 * @receiver [String]
 * @return [Boolean]
 */
fun String.isOnlyChEn(): Boolean = "[a-zA-Z\u4E00-\u9FA5]+".toRegex().matches(this)

/**
 * 判断字符串是否只有中文
 *
 * @receiver [String]
 * @return [Boolean]
 */
fun String.isOnlyChinese(): Boolean = chineseRegex.matches(this)

/**
 * 判断字符串是否只有英文
 *
 * @receiver [String]
 * @return [Boolean]
 */
fun String.isOnlyEnglish(): Boolean = letterRegex.matches(this)

/**
 * 判断字符串是否只有数字
 *
 * @receiver [String]
 * @return [Boolean]
 */
fun String.isOnlyNumber(): Boolean = numberRegex.matches(this)