package Leetcode_1_470;

// 暴力解法
//public class Soluton {
//    public int[] twoSum(int[] nums, int target) {
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{0, 0};
//    }
//}

import java.util.HashMap;

// Hash解法
public class Soluton {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hm = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {

            int item = target - nums[i];

            if (hm.containsKey(item)) {
                return new int[]{hm.get(item), i};
            }
            hm.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}