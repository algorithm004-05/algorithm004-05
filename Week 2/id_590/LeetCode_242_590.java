package homework.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

//https://leetcode-cn.com/problems/valid-anagram/description/
public class LeetCode_242_590 {

    public boolean isAnagram_1(String s, String t) {
        //思路一:将两个字符串排序,比较两个字符串是否相等,时间复杂度O(nlogn)
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();

        //将s_chars和t_chars排序
        Arrays.sort(s_chars);
        Arrays.sort(t_chars);
        return new String(s_chars).equals(new String(t_chars));
    }

    public boolean isAnagram_2(String s, String t) {
        //思路二:遍历s和t的字符,每个s的字符放到数组(26位长度)相应位置(-'a',相当于一个哈希函数),t的字符则相应去减少,最后看
        //每个位置是否不为0,时间复杂度O(n)

        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
