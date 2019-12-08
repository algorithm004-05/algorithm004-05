/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        // 如果n是2的幂次，那么只有一位是1，去掉它，整个就是0了
        // 注意前提，n 要不为0
        return n > 0 && (n&(n-1))==0;
    }
}
// @lc code=end

