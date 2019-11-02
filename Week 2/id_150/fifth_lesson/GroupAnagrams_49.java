package com.geek.lee.leetcode.medium;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */

/**
 * 49. 字母异位词分组
 */
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs || strs.length == 0) {
            return null;
        }
        List<List<String>> result = new ArrayList<>();

        /**
         * 方法1. 将strs元素排序后做为map的key. map的value是list.用于存储key相同的元素
         * 最后将map中value输出
         * 时间复杂度: O(nklogk) : 全量一次循环O(n), 内层每次排序O(klogk)
         */
//        Map<String, List<String>> keyDict = new HashMap<>();
//        for (int i = 0; i < strs.length; i ++) {
//            char[] s = strs[i].toCharArray();
//            Arrays.sort(s);
//            String sKey = String.valueOf(s);
//            // 此处巧妙地通过!判断,减少一层if-else逻辑
//            if (!keyDict.containsKey(sKey)) {
//                keyDict.put(sKey, new ArrayList<>());
//            }
//            keyDict.get(sKey).add(strs[i]);
//        }
//
//        result.addAll(keyDict.values());

        /**
         * 方法2. 作为方法1的变种, 避免排序.
         * 根据字母异位词一题解法来做,可以用一个数组计数器, 将每个单词出现次数记录在数组中.
         * 将数组的每个元素连接起来作为一个map的key.如果是异位词, key一定相同
         * 将排序的O(klogk)转换为O(n)
         * 整体时间复杂度:O(nk)
         */
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            int[] dict = new int[26];
            for (char s : str.toCharArray()) {
                dict[s - 'a'] ++;
            }

            StringBuilder sbd = new StringBuilder();
            for (int k = 0; k < dict.length; k ++) {
                sbd.append(dict[k]);
            }
            String key = sbd.toString();
            if (!resultMap.containsKey(key)) {
                resultMap.put(key, new ArrayList<>());
            }
            resultMap.get(key).add(str);
        }
        result.addAll(resultMap.values());
        return result;
    }

    public static void main(String[] args) {
        new GroupAnagrams_49().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
