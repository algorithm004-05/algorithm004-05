import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */
class Solution {
    public boolean isAnagram(String s, String t) {


        // // 方法一，比较巧妙，每次把s中遍历到的字母的ASICC码计算并且加起来，再减去t中对应的值。
        // // 遍历一遍下来，如果有一个字母的对应的出现次数不为0，则整个传入数据不为字母异位词。
        // // 此方法中new了一个大小为26的数组，其中每一个元素代表一个字母的出现次数，所以最后只要有一个不为0，输入就不为字母异位词
        // if(s.length() != t.length()) {
        //     return false;
        // }
        // int [] count = new int[26];
        // for(int i = 0 ; i < s.length(); i++) {
        //     count[s.charAt(i) - 'a']++;
        //     count[t.charAt(i) - 'a']--;
        // }
        // for(int counter : count) {
        //     if(counter != 0) {
        //         return false;
        //     }
        // }
        // return true;

        // 方法2 排序
        if (s.length() != t.length()) return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}

