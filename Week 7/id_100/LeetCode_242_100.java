/**
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class LeetCode_242_100 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] tables = new int[26];
        for (int i = 0; i < s.length(); i++) {
            tables[s.charAt(i)  - 'a']++;
            tables[t.charAt(i)  - 'a']--;
        }
        for(int num : tables) {
            if(num != 0) {
                return false;
            }
        }
        return true;
    }

}