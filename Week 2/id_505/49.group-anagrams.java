/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (49.93%)
 * Likes:    2149
 * Dislikes: 134
 * Total Accepted:    420.2K
 * Total Submissions: 837.3K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        ArrayList<List<String>> result = new ArrayList<List<String>>();

        for (String s:strs) {
            String sort_s = sort(s);
            if (map.get(sort_s) != null) {
                List<String> list = map.get(sort_s);
                list.add(s);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(sort_s, list);
                result.add(list);
            }
        }

        return result;

    }

    private String sort(String s) {
        char ca[] = s.toCharArray();
        Arrays.sort(ca);
        return new String(ca);
    }


}

// @lc code=end

