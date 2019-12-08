package com.simon.leetcode.w7.lcn191;

public class NumberOf1bits {
    public int hammingWeight(int n) {
        int ret = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                ret++;
            }
            mask <<= 1;
        }
        return ret;
    }
}
