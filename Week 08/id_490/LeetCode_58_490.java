/**
 * 题目名称：length-of-last-word 最后一个单词的长度
 * 题目链接：https://leetcode-cn.com/problems/length-of-last-word/
 */
class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        boolean space = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                space = true;
            } else if (space == true) {
                len = 1;
                space = false;
            } else {
                len++;
            }
        }
        return len;
    }

    public int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;

        return end - start;
    }
}