/*
  242
  Given two strings s and t , write a function to determine if t is an anagram of s.

  Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

  Example 2:
    Input: s = "rat", t = "car"
    Output: false

  Note:
    You may assume the string contains only lowercase alphabets.

  Follow up:
    What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

  public boolean isAnagram0(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    Arrays.sort(sChars);
    Arrays.sort(tChars);

    return Arrays.equals(sChars, tChars);
  }

  public boolean isAnagram1(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> map = new HashMap<>(s.length());

    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (char c : t.toCharArray()) {
      Integer count = map.get(c);
      if (count == null) {
        return false;
      } else if (count > 1) {
        map.put(c, count - 1);
      } else {
        map.remove(c);
      }
    }

    return map.isEmpty();
  }

  public boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] alphabet = new int[26];

    for (char c : s.toCharArray()) {
      alphabet[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
      if (--alphabet[c - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }

  public boolean isAnagram3(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] alphabet = new int[26];

    for (int i = 0; i < s.length(); i++) {
      alphabet[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      alphabet[t.charAt(i) - 'a']--;
    }
    for (int i : alphabet) {
      if (i != 0) {
        return false;
      }
    }
    return true;
  }

  public boolean isAnagram4(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] cs = s.toCharArray();
    char[] ct = t.toCharArray();
    int[] map = new int[127];
    int count = 0;
    for (int i = 0; i < cs.length; i++) {
      if (++map[cs[i]] == 1) {
        count++;
      }
      if (--map[ct[i]] == 0) {
        count--;
      }
    }
    return count == 0;
  }
}
