/*
  49
  Given an array of strings, group anagrams together.

 Example:
    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
    ["ate","eat","tea"],
    ["nat","tan"],
    ["bat"]
    ]

  Note:
    All inputs will be in lowercase.
    The order of your output does not matter.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  public List<List<String>> groupAnagrams0(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<List<String>>();
    }

    Map<String, List<String>> haspMap = new HashMap<>();

    for (String str : strs) {
      char[] key = str.toCharArray();
      Arrays.sort(key);
      List<String> temp = haspMap.getOrDefault(String.valueOf(key), new ArrayList<>());
      temp.add(str);
      haspMap.put(String.valueOf(key), temp);
    }

    return new ArrayList<>(haspMap.values());
  }

  public List<List<String>> groupAnagrams1(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<List<String>>();
    }

    Map<String, List<String>> haspMap = new HashMap<>();

    for (String str : strs) {
      int[] arr = new int[26];
      for (int i = 0; i < str.length(); i++) {
        arr[str.charAt(i) - 'a']++;
      }
      List<String> temp = haspMap.getOrDefault(Arrays.toString(arr), new ArrayList<>());
      temp.add(str);
      haspMap.put(Arrays.toString(arr), temp);
    }

    return new ArrayList<>(haspMap.values());
  }

}
