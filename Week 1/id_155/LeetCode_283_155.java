/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[zeroIndex++] = nums[i];                
            }
        }

        int len = nums.length;
        for(int i = 0; i < len - zeroIndex - 1; i++){
            nums[nums.length - i - 1] = 0;
        }
    }
}
// @lc code=end

