package Leetcode_242_470;

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] hash = new char[26];
        int i = 0;
        int sum;


        for (i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }


        for (i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - 'a']--;
        }


        for (i = 0, sum = 0; i < 26; i++) {
            sum += hash[i];
        }

        return sum == 0 ? true : false;
    }

}
