package xyz.isok.algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 */
public class No242ValidAnagram {

    public static void main(String[] args) {
//        String s = "anagram", t = "nagaram";
        String s = "a", t = "b";
//        String s = "ab", t = "a";
        System.out.println(Solution.isAnagram0(s, t));
        System.out.println(Solution.isAnagram1(s, t));
        System.out.println(Solution.isAnagram2(s, t));
    }

    static class Solution {

        public static boolean isAnagram0(String s, String t) {
            char[] sa = s.toCharArray();
            char[] ta = t.toCharArray();
            if (sa.length != ta.length){
                return false;
            }
            Map<Character, Integer> map = new HashMap<>();
            int length = sa.length;
            for (int i = 0; i < length; i++) {
                Integer count = map.getOrDefault(sa[i], 0);
                map.put(sa[i], count + 1);
                count = map.getOrDefault(ta[i], 0);
                map.put(ta[i], count - 1);
            }
            Set<Map.Entry<Character, Integer>> set = map.entrySet();
            for (Map.Entry<Character, Integer> characterIntegerEntry : set) {
                if (map.get(characterIntegerEntry.getKey()) != 0){
                    return false;
                }
            }
            return true;
        }

        /**
         * 性能更高
         */
        public static boolean isAnagram1(String s, String t) {
            char[] sa = s.toCharArray();
            char[] ta = t.toCharArray();
            Arrays.sort(sa);
            Arrays.sort(ta);
            return String.valueOf(sa).equals(String.valueOf(ta));
        }

        public static boolean isAnagram2(String s, String t) {
            char[] sa = s.toCharArray();
            char[] ta = t.toCharArray();
            Map<Character, Integer> mapS = convert(sa);
            Map<Character, Integer> mapT = convert(ta);
            Set<Map.Entry<Character, Integer>> set = mapS.entrySet();
            for (Map.Entry<Character, Integer> c : set) {
                if (mapS.get(c.getKey()).equals(mapT.get(c.getKey()))){
                    mapT.remove(c.getKey());
                }else {
                    return false;
                }
            }
            return mapT.size() == 0;
        }

        private static Map<Character, Integer> convert(char[] chars) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : chars) {
                Integer count = map.get(c);
                if (null == count){
                    map.put(c, 1);
                }else {
                    map.put(c, count + 1);
                }
            }
            return map;
        }
    }

    public static boolean isAnagram3(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        if (sa.length != ta.length){
            return false;
        }
        Arrays.sort(sa);
        Arrays.sort(ta);
        int length = sa.length;
        for (int i = 0; i < length; i++) {
            if (sa[i] != ta[i]){
                return false;
            }
        }
        return true;
    }

}
