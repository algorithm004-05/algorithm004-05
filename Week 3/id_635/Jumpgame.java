package com.simon.leetcode.lcn55;

public class Jumpgame {
    public boolean canJump(int[] nums) {

        if (nums == null) {
            return false;
        }
        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 逐步向前递推
            if (nums[i] + i >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }

}
