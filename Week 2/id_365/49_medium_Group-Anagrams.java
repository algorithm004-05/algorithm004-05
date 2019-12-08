// 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

// 示例:

// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
// 输出:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List> map = new HashMap<String,List>();
        for(int i = 0; i<strs.length ; i++ ) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String sortStr = String.valueOf(str);
            if(!map.containsKey(sortStr)) {
                map.put(sortStr,new ArrayList());
            }
            map.get(sortStr).add(strs[i]);
        }
        
        return new ArrayList(map.values());
    }
}