/*
  1
  Given an array of integers, return indices of the two numbers
  such that they add up to a specific target.

  You may assume that each input would have exactly one solution,
  and you may not use the same element twice.

  Example:
    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
*/

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public int[] twoSum0(int[] nums, int target) {
    int[] res = new int[2];

    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i +1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          res[0] = i;
          res[1] = j;
          return res;
        }
      }
    }

    return res;
  }

  public int[] twoSum1(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] {i, map.get(complement)};
      }
    }

    throw new IllegalArgumentException("No such solution");
  }

  public int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }

    throw new IllegalArgumentException("No such solution");
  }
}
