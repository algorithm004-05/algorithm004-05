/**
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class LeetCode_190_100 {

    public int reverseBits(int n) {
        int ret = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask&n) != 0) {
                ret |= 1 << (31 - i);
            }
            mask <<= 1;
        }
        return ret;
    }
    
}