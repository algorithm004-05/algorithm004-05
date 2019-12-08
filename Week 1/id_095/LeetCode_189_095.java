/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (31.76%)
 * Likes:    1735
 * Dislikes: 672
 * Total Accepted:    359.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Note:
 * 
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        byReverse(nums, k);
        return;
    }
  
    private void byReverse(int[] nums, int k) {
        if (nums.length == 0 ||  k % nums.length == 0) return;
        k = k % nums.length;
    
    // global reverse
        reverse(nums, 0, nums.length - 1);
    
    // local reverse
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

        return;
  }
  
    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j --) {
          int tmp = nums[i];
          nums[i] = nums[j];
          nums[j] = tmp;
    }
        return;
  }
}

// @lc code=end

