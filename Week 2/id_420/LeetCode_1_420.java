package geekbang.myleetcode.week02;

import java.util.HashMap;
import java.util.Map;

/**
 * lesson03
 */
public class LeetCode_1_420 {
    public static void main(String[] args) {
        //int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        Solution solution = new LeetCode_1_420().new Solution();
        int[] array = solution.twoSum(nums, target);
        System.out.println("main:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int  i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{};
        }
    }
}
