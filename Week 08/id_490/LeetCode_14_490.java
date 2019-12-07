/**
 * 题目名称：longest-common-prefix 最长公共前缀
 * 题目链接：https://leetcode-cn.com/problems/longest-common-prefix/
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) 
                    return strs[0].substring(0, i);
            }
        }

        return strs[0];
    }
}