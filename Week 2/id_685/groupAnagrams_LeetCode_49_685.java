import java.util.Arrays;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    //1.暴力求解
    //判断是否存在，存在就添加到map里面，不存在就创建一个key
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List> map = new HashMap<>();

        for(int i = 0 ; i < strs.length ; i++ ) {
            char [] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if( !map.containsKey(key) ) {
                map.put(key,new ArrayList());
                
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
}
// @lc code=end

