/**
 * 题目名称：reverse-words-in-a-string 翻转字符串里的单词
 * 题目链接：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
class Solution {
    public String reverseWords(String s) {
        StringBuffer ans = new StringBuffer();
        s = s.trim();
        int i = s.length() - 1, j = s.length();
        while (i > 0) {
            if (s.charAt(i) == ' ') {
                ans.append(s.substring(i + 1, j));
                ans.append(' ');
                while (s.charAt(i) == ' ') i--;
                j = i + 1;
            }          
            i--;
        }
        return ans.append(s.substring(0, j)).toString();
    }
}