package com.d10ng.text.data

/**
 * Byte数组填充到指定长度
 * @receiver [ByteArray]
 * @param length [Int] 需要填充到的长度
 * @param filler [Byte] 填充物
 * @param isInStart [Boolean] 是否从开头处填充，
 *                            true：开头；
 *                            false：结尾
 * @param isForced [Boolean] 是否强制性要只保留指定长度数组，
 *                           true：如果ByteArray本身已经比输入长度[length]长，也要只截取其中的部分；
 *                           false：如果ByteArray本身已经比输入长度[length]长，那也不管；
 * @return [ByteArray]
 */
fun ByteArray.up2Length(
    length: Int,
    filler: Byte = 0x00,
    isInStart: Boolean = true,
    isForced: Boolean = true
): ByteArray {
    val list = mutableListOf<Byte>()
    if (!isInStart) list.addAll(this.toList())
    if (this.size < length) {
        for (i in 0 until length - this.size) {
            list.add(filler)
        }
    }
    if (isInStart) list.addAll(this.toList())
    return if (isForced) {
        if (isInStart) list.subList(list.size - length, list.size).toByteArray()
        else list.subList(0, length).toByteArray()
    } else list.toByteArray()
}

/**
 * 从ByteArray中查找特定ByteArray的位置
 * # 如果没有找到就返回-1
 * @receiver [ByteArray] 输入ByteArray
 * @param bs [ByteArray] 检索ByteArray
 * @return [Int] 首个位置index
 */
fun ByteArray.findFirstIndex(bs: ByteArray): Int {
    var index = 0
    while (true) {
        val temp = this.copyOfRange(index, this.size)
        val i = temp.indexOf(bs[0])
        if (i < 0) return -1
        index += (i + 1)
        if (i + bs.size > temp.size) return -1
        if (temp.copyOfRange(i, i + bs.size).contentEquals(bs)) {
            return index -1
        }
    }
}