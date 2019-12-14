package homework.week2;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/group-anagrams/
public class LeetCode_49_590 {
    public List<List<String>> groupAnagrams_1(String[] strs) {
        //思路一,使用字母异位词判断,然后对于结果集进行的每个list进行判断,如果有,就往该集合里添加,如果遍历所有结果中的
        //list还是没有,则生成一个list,将其放入,然后将生成的list放入结果list中,时间复杂度->O(n^2)
        List<List<String>> result = new ArrayList<>();

        //状态变量,代表当前待判断的字符串是否在已有异位词集合里
        boolean status=false;

        for (int i = 0; i < strs.length; i++) {
            status=false;
            //遍历结果集拿到每个list
            for (List<String> strings : result) {
                if (_isAnagram(strings.get(0),strs[i])){
                    //如果判断是该组异位词,则直接加入即可
                    strings.add(strs[i]);
                    status=true;
                    //结束内层循环
                    break;
                }
            }

           if (status == true){
               //已经将当前次的字符串填入已有的异位字符串,则进入下次大循环
               continue;
           }else{
               ArrayList<String> new_strings = new ArrayList<>();
               new_strings.add(strs[i]);
               result.add(new_strings);
           }
        }

        return result;
    }

    public boolean _isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
