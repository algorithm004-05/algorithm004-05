package com.company;

public class LeetCode_26_540 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int replaceIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[replaceIndex - 1]) {
                nums[replaceIndex] = nums[i];

                replaceIndex++;
            }
        }

        return replaceIndex;
    }
}
