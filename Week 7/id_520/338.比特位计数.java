/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {
        // 方法一
        // 动态规划 + 最后设置位
        // DP 方程： dp(x) = dp(x&(x-1))+1
        // dp(i)表示下标为i时二进制表示的 1 的数量
        // int[] result = new int[num+1];
        // for(int i = 1; i <= num; i++) {
        //     result[i] = result[i&(i-1)]+1;
        // }
        // return result;

        // 方法二 DP+最低有效位
        // DP方程：result[i] = result[i/2]+result[i%2]
        int[] result = new int[num+1];
        for (int i = 1; i <= num; i++) {
            // x / 2 is x >> 1 and x % 2 is x & 1
            result[i] = result[i>>1] + (i&1); 
        }
        return result;
    }
    
}
// @lc code=end

