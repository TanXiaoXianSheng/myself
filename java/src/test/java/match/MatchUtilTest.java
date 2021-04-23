package match;

import org.junit.After;
import org.junit.Test;

import static java.lang.System.*;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/20 5:23 下午
 */
public class MatchUtilTest {

    String str = "";
    Boolean bool = true;

    @After
    public void after() {
        out.println(bool);
    }

    @Test
    public void test002() {
        str = "123";
        bool = MatchUtil.DigitUtil.digitAll(str);
    }

    @Test
    public void test003() {
        str = "123A";
        bool = MatchUtil.DigitUtil.digitAll(str);
    }

    @Test
    public void test004() {
        str = "123A";
        bool = MatchUtil.DigitUtil.digitAllNot(str);
    }

    @Test
    public void test005() {
        str = "ABCD_";
        bool = MatchUtil.DigitUtil.digitAllNot(str);
    }

    @Test
    public void test006() {
        str = "123";
        bool = MatchUtil.DigitUtil.digitFix(str, 3);
    }

    @Test
    public void test007() {
        str = "123";
        bool = MatchUtil.DigitUtil.digitFix(str, 4);
    }

    @Test
    public void test008() {
        str = "1ab";
        bool = MatchUtil.DigitUtil.digitFix(str, 3);
    }

    @Test
    public void test009() {

    }

    @Test
    public void test010() {

    }

    @Test
    public void test011() {

    }

    @Test
    public void test012() {

    }

    @Test
    public void test013() {

    }

    @Test
    public void test014() {

    }

    @Test
    public void test015() {

    }

    @Test
    public void test016() {

    }

    @Test
    public void test017() {

    }

    @Test
    public void test018() {

    }


}
