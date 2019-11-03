package leetcode.jacf.tech;

import java.util.HashMap;

/**
 * @author jacf
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> array = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (array.containsKey(diff)) {
                return new int[]{array.get(diff), i};
            } else {
                array.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
