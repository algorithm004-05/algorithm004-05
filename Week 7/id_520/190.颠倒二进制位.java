/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0 ; i < 32; i++) {
            // 1. 将给定的二进制数，由低到高位逐个取出
            // 1.1 右移 i 位
            int tmp = n>>i;
            // 1.2 取有效位
            tmp = tmp&1;
            // 2.通过位运算将其放置到反转后的位置
            tmp = tmp << (31-i);
            // 3.将上述结果再次通过运算结合到一起
            result = result | tmp;
        }
        return result;
    }
}
// @lc code=end

