/**
 * 题目名称：valid-anagram 有效的字母异位词
 * 题目链接：https://leetcode-cn.com/problems/valid-anagram/
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] counter = new int[26];
        for (int i=0; i<s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}