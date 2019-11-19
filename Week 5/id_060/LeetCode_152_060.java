/*
  152
  Given an integer array nums, find the contiguous subarray within an array
  (containing at least one number) which has the largest product.

  Example 1:
    Input: [2,3,-2,4]
    Output: 6

  Explanation: 
    [2,3] has the largest product 6.

  Example 2:
    Input: [-2,0,-1]
    Output: 0

  Explanation: 
    The result cannot be 2, because [-2,-1] is not a subarray.
*/

public class MaximumProductSubarray {

  public int maxProduct2(int[] nums) {
    int max = Integer.MIN_VALUE, imax = 1, imin = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        int tmp = imax;
        imax = imin;
        imin = tmp;
      }
      imax = Math.max(imax * nums[i], nums[i]);
      imin = Math.min(imin * nums[i], nums[i]);

      max = Math.max(max, imax);
    }
    return max;
  }
}
