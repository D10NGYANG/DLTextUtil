package com.d10ng.text.string

import com.github.promeg.pinyinhelper.Pinyin

/**
 * 字符串转拼音字符串
 * @receiver String
 * @param separator String 分隔符
 * @return String
 */
fun String.toPinYin(separator: String = ""): String = Pinyin.toPinyin(this, separator)