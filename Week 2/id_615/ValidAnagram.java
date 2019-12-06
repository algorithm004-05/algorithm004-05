package com.chenlei.geektime.leetcode;

import java.util.Arrays;

/**
 * 有效字母异位，字母异位即两个字符串包含字母相同但字母位置不同
 * https://leetcode-cn.com/problems/valid-anagram/description/
 */
public class ValidAnagram {
    //方式一 排序
    public boolean isAnagram(String s, String t) {
        //简单校验
        if(s.length() != t.length()){
            return false;
        }
        //转换为数组
        char[] s1  = s.toCharArray();
        char[] t1  = t.toCharArray();

        //排序
        Arrays.sort(s1);
        Arrays.sort(t1);

        //比较结果
       return Arrays.equals(s1,t1);
    }

    //方式二 哈希表
    public boolean isAnagram2(String s, String t) {
        //简单校验
        if(s.length() != t.length()){
            return false;
        }

        //计数器 26个字母
        int[] counter = new int[26];
        for (int i = 0; i < s.length() ; i++) {
//            s.charAt(i) - 'a' 将获取到的字符串的hash值
//            System.out.println((s.charAt(i) - 'a')  + " - " +(t.charAt(i) - 'a'));

            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if(count != 0){
                return false;
            }
        }

        return true;
    }

//    public static void main(String[] args) {
//        ValidAnagram va =  new ValidAnagram();
//
//        va.isAnagram2("anagram","nagaram");
//    }
}
