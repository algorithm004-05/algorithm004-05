package id_430;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_242_430 {

  /**
   * 时间复杂度较高，不如数组
   */
  class Solution1 {
    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }
      Map<Character, Integer> map1 = new HashMap(26);
      Map<Character, Integer> map2 = new HashMap(26);
      for (int i = 0; i < s.length(); i++) {
        map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
      }
      return map1.equals(map2);
    }
  }

  /**
   * 最优解法，比整体equals好
   */
  class Solution2 {
    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }
      // 不要循环时才计算
      int n = s.length();
      int[] count = new int[26];
      for (int i = 0; i < n; i++) {
        // 不要频繁计算charAt
        int c = s.charAt(i) - 'a';
        count[c] = count[c] + 1;
      }
      // 两个循环不能合到一起，否则t先统计时会先出现负数
      for (int i = 0; i < n; i++) {
        int c = t.charAt(i) - 'a';
        count[c] = count[c] - 1;
        // 至少有个字母，a没有b有或a比b少
        if (count[c] < 0) {
          return false;
        }
      }
      return true;
    }
  }

  /**
   * 数组作为map
   */
  class Solution3 {
    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }
      int[] count1 = new int[26];
      int[] count2 = new int[26];
      int n = s.length();
      for (int i = 0; i < n; i++) {
        // 循环内access耗时，最好存起来
        int a = s.charAt(i) - 'a';
        int b = t.charAt(i) - 'a';
        count1[a] = count1[a] + 1;
        count2[b] = count2[b] + 1;
      }
      // count1.equals(count2)不行
      return Arrays.equals(count1, count2);
    }
  }

}