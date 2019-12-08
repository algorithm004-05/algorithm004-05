/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (56.13%)
 * Likes:    118
 * Dislikes: 0
 * Total Accepted:    53K
 * Total Submissions: 93.7K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        
        // 字符串长度不相等 false
        if (s.length() != t.length()) return false;
        // 声明一个 26位计数器, 因为 S 和 T 都只包含 A - Z 
        int [] counter = new int [26];
        // 计算 s 每个字母的频率, 减少 t 每个字母出现的频率
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        // 检查每个字母计数 是否为零. 
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) return false;
        }
        return true;
    }
}
// @lc code=end

