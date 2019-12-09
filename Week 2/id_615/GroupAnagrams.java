package com.chenlei.geektime.leetcode;

import java.util.*;

/**
 * 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GroupAnagrams {

    /**
     * 方式一 按计数分类
     * 当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //简单校验
        if(strs.length == 0){
            return new ArrayList<>();
        }
        //使用hash值保存key,每个字母hash值用#分割，总共26个字母
        Map<String ,List<String>> result = new HashMap<>();

        int[] counter = new int[26];

        for (String str : strs) {

            Arrays.fill(counter,0);

            for (char c : str.toCharArray()) counter[c - 'a']++;

            StringBuilder sb  = new StringBuilder("");
            for (int i = 0 ; i < 26 ;i++){
                sb.append('#');
                sb.append(counter[i]);
            }

            String key = sb.toString();
            if(!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }

            result.get(key).add(str);

        }

        return new ArrayList<>(result.values());

    }
}
