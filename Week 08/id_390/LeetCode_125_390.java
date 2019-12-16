//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串



//leetcode submit region begin(Prohibit modification and deletion)
// 1. 暴力法 时间O(n) 空间O(1)
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int len = s.length();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            while (!valid(s.charAt(i)) ) {
                if (i == j) {
                    break;
                }
                i++;
            }
            while (!valid(s.charAt(j))) {
                if (i == j) {
                    break;
                }
                j--;
            }
            if (change(s.charAt(i)) != change(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }
    private char change (char ch) {
        if ((int)ch >= 65 && (int)ch <= 90) {
            return (char)((int)ch + 32);
        }
        return ch;
    }
    private boolean valid (char ch) {
        if ((int)ch >= 65 && (int)ch <= 90) {
            return true;
        }
        if ((int)ch >= 97 && (int)ch <= 122) {
            return true;
        }
        if ((int)ch >= 48 && (int)ch <= 57) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
