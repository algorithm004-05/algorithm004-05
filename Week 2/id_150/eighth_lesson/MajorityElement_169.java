package com.geek.lee.leetcode.easy;
/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 求众数
 */
public class MajorityElement_169 {

    public int majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int limit = nums.length / 2;

        /**
         * 解法1. 暴力法之上构建hash表
         * 两层循环统计
         */

        return majorityElementByLoop(nums, limit);
    }

    /**
     * hash表实现
     * 通过hash表记录每个元素出现的次数.满足条件即返回.
     * @param nums
     * @param limit
     * @return
     */
    private int majorityElementByLoop(int[] nums, int limit) {
        Map<Integer, Integer> dict = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            if (dict.containsKey(nums[i])) {
                dict.put(nums[i], dict.get(nums[i]) + 1);
            } else {
                dict.put(nums[i], 1);
            }

            if (dict.get(nums[i]) > limit) {
                return nums[i];
            }
        }

        return 0;
    }
}
