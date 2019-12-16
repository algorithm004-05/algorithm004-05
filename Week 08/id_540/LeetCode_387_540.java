package com.company;

import java.util.HashMap;

public class LeetCode_387_540 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charCountMap.put(chars[i], charCountMap.getOrDefault(chars[i], 0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (charCountMap.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }
}
