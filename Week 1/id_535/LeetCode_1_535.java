package id_535;

import java.util.HashMap;
import java.util.Map;

/**
 * created by lchen on 2019/10/20
 */
public class LeetCode_1_535 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = solution2.twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer val = indexMap.get(nums[i]);
            if (val != null) {
                index[0] = val;
                index[1] = i;
            } else {
                indexMap.put(target - nums[i], i);
            }
        }
        return index;
    }
}