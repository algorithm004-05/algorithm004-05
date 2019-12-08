package com.geek.lee.leetcode.easy;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效字母异位词
 */
public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        /**
         * 解法1. 排序后比较
         */
//        char[] charArrS = s.toCharArray();
//        char[] charArrT = t.toCharArray();
//
//        Arrays.sort(charArrS);
//        Arrays.sort(charArrT);
//
//        return Arrays.equals(charArrS, charArrT);

        /**
         * 解法2. hash表
         * 将s字符串出现的元素及次数加入到hashMap中. key: 字母 value:次数
         * 将t字符串出现的元素从hashMap中剔除,最后map为空则表示是正确的异位词
         */
//        Map<Character, Integer> dict = new HashMap<>();
//
//        char[] charArrS = s.toCharArray();
//        char[] charArrT = t.toCharArray();
//
//        for (int i = 0; i < charArrS.length; i ++) {
//            if (dict.containsKey(charArrS[i])) {
//                dict.put(charArrS[i], dict.get(charArrS[i]) + 1);
//            } else {
//                dict.put(charArrS[i], 1);
//            }
//        }
//
//        for (int i = 0; i < charArrT.length; i ++) {
//            if (!dict.containsKey(charArrT[i])) {
//                return false;
//            }
//            if (dict.get(charArrT[i]) == 1) {
//                dict.remove(charArrT[i]);
//            } else {
//                dict.put(charArrT[i], dict.get(charArrT[i]) - 1);
//            }
//        }
//
//        return dict == null || dict.size() <= 0;

        /**
         * 方法3. 模拟hash表.
         * 通过一个int数组,记录a-z的26个字母
         * 下标为字母charAt, 值为字母出现次数
         * S字符串累加计数; t字符串递减计数.
         * 最后所有位置元素都为0,即时异位词
         */

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            counter[s.charAt(i) - 'a'] ++;
            counter[t.charAt(i) - 'a'] --;
        }

        for (int i = 0; i < counter.length; i ++) {
            if (counter[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsAnagram_242().isAnagram("anagram", "nagaram"));
    }
}
