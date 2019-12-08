package com.company;

import java.util.Arrays;

public class LeetCode_169_540 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
