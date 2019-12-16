/**
 * 题目名称：reverse-string 反转字符串
 * 题目链接：https://leetcode-cn.com/problems/reverse-string/
 */
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}