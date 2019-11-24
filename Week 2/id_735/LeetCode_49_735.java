import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (58.67%)
 * Likes:    200
 * Dislikes: 0
 * Total Accepted:    33.8K
 * Total Submissions: 57.3K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // 空判断
        if (strs.length == 0) return new ArrayList<>();
        // 声明 hash 表
        Map <String, List> map = new HashMap<>();
        // 遍历所有字符串
        for (String string : strs) {
            // 排序字符串
            char[] c = string.toCharArray();
            Arrays.sort(c);
            //  以排序后的字符串为 key, 去 hash 表中查找, 如果包含就把原字符串添加进去, 不包含就添加一个数组
            String key = String.valueOf(c);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());   
            }
            map.get(key).add(string);
        }
        return new ArrayList(map.values());
    }
}
// @lc code=end

