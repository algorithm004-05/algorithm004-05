/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int x, int y){
        while(x < y){
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
            x++;
            y--;
        }
    }
}
// @lc code=end

