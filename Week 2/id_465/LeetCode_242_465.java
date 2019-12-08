package leetcode.jacf.tech;


import java.util.HashMap;

/**
 * @author jacf
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * 异位词即包含字母个数、频率一致，但顺序不一致的单词
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        // 长度不一致肯定不是异位词
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> frequency = new HashMap<Character, Integer>(s.length());

        // 生成频数字典
        for (Character c : s.toLowerCase().toCharArray()
        ) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        for (Character c : t.toLowerCase().toCharArray()
        ) {
            if (!frequency.containsKey(c)) {
                return false;
            }

            int count = frequency.get(c);
            if (count == 0) {
                return false;
            } else {
                frequency.put(c, count - 1);
            }
        }

        return true;
    }

    private static boolean isAnagramUsingArray(String s, String t) {
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
