package match;

import javax.validation.Valid;

/**
 * 字符串正则匹配工具类
 *
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/20 5:09 下午
 */
public class MatchUtil {

    /**
     * 纯数字匹配
     */
    protected static class DigitUtil {

        /**
         * 全部是数字
         * @param str
         * @return
         */
        protected static boolean digitAll(String str) {
            return str.matches("\\d+");
        }

        /**
         * 全部不是数字
         * @param str
         * @return
         */
        protected static boolean digitAllNot(String str) {
            return str.matches("\\D+");
        }

        /**
         * 长度为 n 的数字
         * @param str
         * @param n 长度
         * @return
         */
        protected static boolean digitFix(String str, int n) {
            return str.matches("\\d{" + n + "}");
        }

    }

    /**
     * 字母
     */
    protected static class charUtil {

        protected static boolean lowerAll(String str) {
            return str.matches("[a-z]+");
        }

        protected static boolean upperAll(String str) {
            return str.matches("[A-Z]+");
        }

        protected static boolean all(String str) {
            return str.matches("[a-zA-Z]+");
        }



    }

}
