package com.company;

public class LeetCode_191_540 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counter = 0;
        while (n != 0) {
            counter++;
            n = n&(n-1);
        }

        return counter;
    }
}
