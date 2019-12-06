package id_430;

import java.util.Arrays;

/**
 * @Author Shuangshuang Wang, <shshwang@mobvoi.com>
 * @Date 2019/10/27
 */
public class LeetCode_169_430 {

  /**
   * 排序法，简洁，时间复杂度O(nlogn)
   */
  class Solution1 {
    public int majorityElement(int[] nums) {
      Arrays.sort(nums);
      return nums[nums.length / 2];
    }
  }

  /**
   * 分治计算众数，时间复杂度O(log(n))（个人感觉是O(n)，至少要把所有数都遍历一遍）
   */
  class Solution2 {
    public int majorityElement(int[] nums) {
      return majorityInRange(nums, 0, nums.length - 1);
    }

    private int majorityInRange(int[] nums, int lo, int hi) {
      if (hi == lo) {
        return nums[lo];
      }
      int mid = (hi - lo) / 2 + lo;
      int leftM = majorityInRange(nums, lo, mid);
      int rightM = majorityInRange(nums, mid + 1, hi);
      if (leftM == rightM) {
        return leftM;
      }
      // 注意不再二分了，计算整个区间
      int c1 = countInRange(nums, leftM, lo, hi);
      int c2 = countInRange(nums, rightM, lo, hi);
      return c1 >= c2 ? leftM : rightM;
    }

    // 计算区间中的众数个数
    private int countInRange(int[] nums, int num, int lo, int hi) {
      int c = 0;
      for (int i = lo; i <= hi; i++) {
        if (nums[i] == num) {
          c++;
        }
      }
      return c;
    }
  }
}
