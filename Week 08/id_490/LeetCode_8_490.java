/**
 * 题目名称：string-to-integer-atoi 字符串转换整数 (atoi)
 * 题目链接：https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
class Solution {
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        if (str.length() == 0) return 0;
        // remove spaces
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index >= str.length()) return 0;
        // handle signs
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        // convert to number and check overflow
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;
            // check overflow
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
            index++;          
        }

        return total * sign;
    }
}