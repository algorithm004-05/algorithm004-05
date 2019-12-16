/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.12.8 12:11
 * @Description:
 */
public class A680 {
    public static void main(String[] args) {
        A680 a680 = new A680();
        String s = "abc";
        System.out.println(a680.validPalindrome(s));
    }


    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        for (; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                break;
            }
        }

        // 如果舍弃左边一个或者右边一个，就可以通过，那么就符合题意
        if (isValid(chars, i + 1, j) || isValid(chars, i, j - 1)) {
            return true;
        }
        return false;
    }

    // 验证
    private boolean isValid(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }

}
