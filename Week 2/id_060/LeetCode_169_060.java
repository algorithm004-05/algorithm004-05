/*
  169
  Given an array of size n, find the majority element.
  The majority element is the element that appears more than ⌊ n/2 ⌋ times.
  You may assume that the array is non-empty and the majority element always exist in the array.

   Example 1:
    Input: [3,2,3]
    Output: 3

  Example 2:
    Input: [2,2,1,1,1,2,2]
    Output: 2
*/

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

  public int getMajorityElement0(int[] nums) {
    Map<Integer, Integer> countMap = new HashMap<>();
    int maxCount = 0, maxNum = 0;
    for (int num : nums) {
      int count = countMap.getOrDefault(num, 0) + 1;
      countMap.put(num, count);
      if (count > maxCount) {
        maxCount = count;
        maxNum = num;
      }
    }
    return maxNum;
  }

  public int getMajorityElement1(int[] nums) {
    int candidate = nums[0], count = 1;
    for (int i = 1; i < nums.length; ++i) {
      if (count == 0) {
        candidate = nums[i];
        count = 1;
      } else if (nums[i] == candidate) {
        count++;
      } else {
        count--;
      }
    }
    return candidate;
  }

  public int getMajorityElement2(int[] nums) {
    return getMajorityElement2Exc(nums, 0, nums.length - 1);
  }

  private int getMajorityElement2Exc(int[] nums, int low, int high) {
    if (low == high) {
      return nums[low];
    }

    int mid = (low + high) >>> 1;
    int left = getMajorityElement2Exc(nums, low, mid);
    int right = getMajorityElement2Exc(nums, mid + 1, high);

    if (left == right) {
      return left;
    }

    return countInRange(nums, left, low, high) > countInRange(nums, right, low, high) ? left : right;
  }

  private int countInRange(int[] nums, int num, int low, int high) {
    int count = 0;
    for (int i = low; i <= high; i++) {
      if (nums[i] == num) {
        count++;
      }
    }
    return count;
  }
}
