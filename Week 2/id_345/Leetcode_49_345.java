package xyz.isok.algorithm.leetcode.medium;

import java.util.*;

public class No49GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Solution.groupAnagrams(strs));
        System.out.println(Solution.groupAnagrams1(strs));

    }

    static class Solution {
        public static List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> lists = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] cs = str.toCharArray();
                Arrays.sort(cs);
                String key = String.valueOf(cs);
                List list = map.get(key);
                if (null == list) {
                    list = new ArrayList();
                    map.put(key, list);
                }
                list.add(str);
            }
            Set<Map.Entry<String, List<String>>> set = map.entrySet();
            for (Map.Entry<String, List<String>> stringListEntry : set) {
                lists.add(stringListEntry.getValue());
            }
            return lists;
        }

        public static List<List<String>> groupAnagrams1(String[] strs) {
            int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
            Map<Integer, List<String>> map = new HashMap<>();
            for (String str : strs) {
                int key = 1;
                for (char c : str.toCharArray()) {
                    key *= prime[c - 'a'];
                }
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<String>());
                }
                map.get(key).add(str);
            }
            return new ArrayList<>(map.values());
        }

    }

}
