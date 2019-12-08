/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int i = 0, j = 31, retVal = 0, temp;
        while (i < j) {
            temp = n >> i;
            temp &= 1;
            temp <<= j;
            retVal |= temp;
            temp = n >> j;
            temp &= 1;
            temp <<= i;
            retVal |= temp;
            i++;
            j--;
        }
        return retVal;
    }
}
// @lc code=end

