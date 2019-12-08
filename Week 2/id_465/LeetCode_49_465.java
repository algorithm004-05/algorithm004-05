package leetcode.jacf.tech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author jacf
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, ArrayList<String>> result = new HashMap<>(strs.length);

        for (int i = 0; i < strs.length; ++i) {
            char[] ss = strs[i].toCharArray();
            Arrays.sort(ss);
            String key = String.valueOf(ss);
            if (result.containsKey(key)) {
                result.get(key).add(strs[i]);
            } else {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                result.put(key, tmp);
            }
        }

        return new ArrayList<>(result.values());
    }

    private static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            frequency[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); ++i) {
            int count = frequency[t.charAt(i) - 'a'];
            if (count == 0) {
                return false;
            } else {
                frequency[t.charAt(i) - 'a']--;
            }
        }
        return true;
    }
}
