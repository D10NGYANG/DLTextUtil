import com.d10ng.text.string.toPinYin

class Test {

    @org.junit.Test
    fun textPinYin() {
        assert("中文".toPinYin().contains("ZHONGWEN", true))
    }
}