import com.d10ng.text.data.toHanZiByteArray
import com.d10ng.text.data.toHexString
import com.d10ng.text.string.toPinYin
import org.junit.Test

class Test {

    @Test
    fun textPinYin() {
        assert("中文".toPinYin().contains("ZHONGWEN", true))
        println("测试123".toHanZiByteArray().toHexString())
        println("测试123".toByteArray(Charsets.UTF_8).toHexString())
    }
}