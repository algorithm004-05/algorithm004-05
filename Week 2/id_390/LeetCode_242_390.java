//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表



//leetcode submit region begin(Prohibit modification and deletion)
// 1. 暴力法 先将字符串转化成数组，将数组排序后比较数组是否相等，排序和比较都需要使用Arrays工具类      时间O(nlogn) 空间O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { // 注意：此处使用的是length()方法
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1); // 快排 O(nlogn)
        Arrays.sort(str2);
        return Arrays.equals(str1, str2); // O(n)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
