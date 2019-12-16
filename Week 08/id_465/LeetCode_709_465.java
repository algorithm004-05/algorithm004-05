/**
 * 709. 转换成小写字母
 * https://leetcode-cn.com/problems/to-lower-case/
 */
class Solution {
    public static String toLowerCase(String str) {
        char[] st = new char[str.length()];
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c >= 65 && c <= 90) {
                c = (char) (c + 32);
            }
            st[i] = c;
        }
        return new String(st);
    }
}