// Copyright(c) 2019 Mobvoi Inc. All Rights Reserved. 

/**
 * @Author Shuangshuang Wang, <shshwang@mobvoi.com>
 * @Date 2019/11/3
 */
public class LeetCode_33_430 {
  class Solution {
    public int search(int[] nums, int target) {
      if (nums.length == 0) {
        return -1;
      }
      int start = 0;
      int end = nums.length - 1;
      // 等号很重要,可能end就是start
      while (start <= end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
          return mid;
          // 等号很重要，mid可能等于0
          // mid之后有分段，后面是或的关系
        } else if (nums[mid] >= nums[0] && (nums[mid] < target || nums[0] > target)
            // mid之后无分段，后面是与的关系
            || nums[mid] < nums[0] && (nums[mid] < target && nums[0] > target)) {
          start = mid + 1;
          // end是mid-1，因mid已无效
        } else {
          end = mid - 1;
        }
      }
      return -1;
    }
  }

  /**
   * 寻找半有序数组的乱序点
   * 
   * @param nums
   * @return
   */
  private static int findGap(int[] nums) {
    if (nums.length == 0 || nums.length == 1) {
      return -1;
    }
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
        return mid;
      }
      // mid在左半段
      if (nums[mid] >= nums[0]) {
        start = mid + 1;
        // mid在右半段
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(findGap(new int[] { 4, 4, 4, 1, 1 }));
  }
}
