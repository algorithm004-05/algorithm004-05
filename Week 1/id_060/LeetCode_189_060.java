/*
  189
  Given an array, rotate the array to the right by k steps, where k is non-negative.

  Example 1:
    Input: [1,2,3,4,5,6,7] and k = 3
    Output: [5,6,7,1,2,3,4]

  Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]

  Example 2:
    Input: [-1,-100,3,99] and k = 2
    Output: [3,99,-1,-100]

  Explanation:
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]
    Note:

  Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
  Could you do it in-place with O(1) extra space?
*/

public class RotateArray {
  public void rotate0(int[] nums, int k) {
    for (int count = 0; count < k; count++) {
      int rotatedElement = nums[nums.length - 1];
      System.arraycopy(nums, 0, nums, 1, nums.length - 1);
      nums[0] = rotatedElement;
    }
  }

  public void rotate1(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length -1);
  }

  private void reverse(int[] nums, int left, int right) {
    while (left < right) {
      swap(nums, left, right);
      left++;
      right--;
    }
  }

  private void swap(int[] nums, int p, int q) {
    if (p == q) {
      return;
    }

    int temp = nums[p];
    nums[p] = nums[q];
    nums[q] = temp;
  }
}
