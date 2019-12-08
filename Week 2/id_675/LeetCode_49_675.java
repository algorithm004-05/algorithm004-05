//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import com.sun.tools.hat.internal.util.ArraySorter;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 )  return new ArrayList();
        Map<String,List> result = new HashMap<String,List>();
        for (String a : strs){
            char[] chars = a.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(String.valueOf(chars));
            if (!result.containsKey(key)) result.put(key,new ArrayList());
            result.get(key).add(a);
        }
        return new ArrayList(result.values());
        /**
         * 全排序，循环比较

         List<List<String>>  re = new ArrayList<List<String>>();

         for (int i = 0;i<strs.length;i++){
         if (strs[i] == null) continue;;
         List<String> strings = new ArrayList<String>();
         char[] a = strs[i].toCharArray();
         Arrays.sort(a);
         strings.add(strs[i]);
         for (int j = i+1;j<strs.length;j++){
         if (strs[j] == null) continue;
         char[] b = strs[j].toCharArray();
         Arrays.sort(b);
         if (Arrays.equals(a,b)){
         strings.add(strs[j]);
         strs[j] = null;
         }
         }
         re.add(strings);
         }*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
