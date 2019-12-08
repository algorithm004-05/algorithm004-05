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



//leetcode submit region begin(Prohibit modification and deletion)
// 1. 排序检查法  对每个字符串进行排序然后判断是否有相同组  时间O(NKlogK) 空间O(NK)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int counter = 0; // 用于记录有多少中不同的组，同时表示下标
        List<List<String>> lists = new ArrayList<List<String>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String str : strs) {
            String strSort = sortString(str);
            if(map.get(strSort) != null) {
                lists.get(map.get(strSort)).add(str);
            } else {
                map.put(strSort, counter);
                List<String> list = new ArrayList<String>();
                list.add(str);
                lists.add(list);
                counter++;
            }
        }
        return lists;
    }

    public String sortString(String str) {
        char[] chs = str.toCharArray(); //先将字符串转化成数组
        Arrays.sort(chs); // 快排 O(nlogn)
        return String.valueOf(chs);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
