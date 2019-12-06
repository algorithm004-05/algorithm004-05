//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//案例:
//
//s = "leetcode"
//返回 0.
//
//s = "loveleetcode",
//返回 2.
// 
//
//注意事项：您可以假定该字符串只包含小写字母。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.HashMap;

public class LeetCode_387_295 {
    // 时间复杂度 O(n)，只遍历了两遍字符串，同时散列表中查找操作是常数时间复杂度的。
    // 空间复杂度 O(n)，用到了散列表来存储字符串中每个元素出现的次数。
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
