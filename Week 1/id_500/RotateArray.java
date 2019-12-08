package array;

import java.util.Arrays;

/**
 * Leetcode: https://leetcode.com/problems/rotate-array/
 *
 * @author Ethan L H LIANG
 * @since 2019.10.20
 */
public class RotateArray {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    rotate(nums, 3);
    System.out.println(Arrays.toString(nums));
  }


  public static void rotate(int[] nums, int k) {
    if (nums.length <= 1) return;
    k = k % nums.length;
    int[] tmpArr = new int[k];
    System.arraycopy(nums, nums.length - k, tmpArr, 0, k);
    System.arraycopy(nums, 0, nums, k, nums.length - k);
    System.arraycopy(tmpArr, 0, nums, 0, tmpArr.length);
  }


}
