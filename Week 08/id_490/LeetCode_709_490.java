/**
 * 题目名称：to-lower-case 转换成小写字母
 * 题目链接：https://leetcode-cn.com/problems/to-lower-case/
 */
class Solution {
    public String toLowerCase(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char)(c + 32);
            }
            newStr += c;
        }
        return newStr;
    }
}