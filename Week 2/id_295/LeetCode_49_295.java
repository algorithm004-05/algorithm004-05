//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
//示例:
//
//输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//说明：
//
//所有输入均为小写字母。
//不考虑答案输出的顺序。
//
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/group-anagrams
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


import java.util.*;

public class LeetCode_49_295 {
    //    1. 按计数分类
    //    思路
    //      当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。

    //    算法
    //      将字符数散列化表示用 # 分割字符串，例如，abbccc 将表示为 ＃1＃2＃3＃0＃0＃0 ...＃0，其中总共有26个条目。
    //      在 Python 中，表示将是一个计数的元组。 例如，abbccc 将表示为 (1,2,3,0,0，...，0)，其中总共有 26 个条目。

    //    复杂度分析
    //    时间复杂度：O(NK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。计算每个字符串的字符串大小是线性的。
    //    空间复杂度：O(NK)，排序存储在 map 中的全部信息内容。
    class Solution1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList<>();
            Map<String, List> map = new HashMap<>();
            int[] count = new int[26];
            for (String s : strs) {
                Arrays.fill(count, 0);
                for (char c : s.toCharArray()) count[c - 'a']++;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    sb.append('#');
                    sb.append(count[i]);
                }
                String key = sb.toString();
                if (!map.containsKey(key)) map.put(key, new ArrayList());
                map.get(key).add(s);
            }
            return new ArrayList(map.values());
        }
    }

    //    2. 排序数组分类
    //    思路
    //      当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
    //    算法
    //      维护一个映射 map : {String -> List}，其中每个键 K 是一个排序字符串，每个值是初始输入的字符串列表，排序后等于 K。
    //      在 Java 中，我们将键存储为字符串，例如，code。 在 Python 中，我们将键存储为散列化元组，例如，('c', 'o', 'd', 'e')。
    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList();
            Map<String, List> map = new HashMap<>();
            for (String str : strs) {
                char[] ca = str.toCharArray();
                Arrays.sort(ca);
                String key = String.valueOf(ca);
                if (!map.containsKey(key)) map.put(key, new ArrayList());
                map.get(key).add(str);
            }
            return new ArrayList(map.values());
        }
    }
}
