//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//示例 1:
//
//输入: s = "anagram", t = "nagaram"
//输出: true
//示例 2:
//
//输入: s = "rat", t = "car"
//输出: false
//说明:
//你可以假设字符串只包含小写字母。
//
//进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/valid-anagram
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


import java.util.Arrays;

public class LeetCode_242_295 {

    //    1. 排序后比较
    //    时间复杂度 O(NlogN) 排序所需时间 O(NlogN)，比较所需时间 O(N)
    //    空间复杂度 O(1) （堆排序），具体依赖于不同语言的细节，Java 里 toCharArray() 制作了一个字符串的拷贝，所以它花费 O(N) 额外的空间
    class Solution1 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            char[] s1 = s.toCharArray();
            char[] s2 = t.toCharArray();
            Arrays.sort(s1);
            Arrays.sort(s2);
            return Arrays.equals(s1, s2);
        }
    }

    //    2. HashMap
    //    思路：开一个大小为 26 的数组，用一个计数器来计数，如果字母在 s 中出现则 +1，在 t 中出现则 -1
    //    时间复杂度 O(N) 访问 counter 是一个固定的时间操作
    //    空间复杂度 O(1) 尽管有额外空间，但空间但复杂性为 O(1)，无论 N 有多大，空间都保持不变
    class Solution2 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a']++;
                counter[t.charAt(i) - 'a']--;
            }
            for (int count : counter) {
                if (count != 0) return false;
            }
            return true;
        }
    }
}
