/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 方法一，循环和位移动
        // int nums = 0, mask = 1;
        // for (int i = 0 ; i < 32; i++) {
        //     if ((n & mask) != 0) {
        //         nums++;
        //     } 
        //     mask <<= 1;
        // }
        // return nums;
        
        // 方法二， 位操作的小技巧
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
// @lc code=end

