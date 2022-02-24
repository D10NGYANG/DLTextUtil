import com.d10ng.text.string.toPinYin
import org.junit.Test

class Test {

    @Test
    fun textPinYin() {
        assert("中文".toPinYin().contains("ZHONGWEN", true))
    }
}