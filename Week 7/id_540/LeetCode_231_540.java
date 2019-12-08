package com.company;

public class LeetCode_231_540 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n&(n - 1)) == 0;
    }
}
