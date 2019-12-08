/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[count]){
                nums[++count] = nums[i];
            }
        }
        return count + 1;
    }
}
// @lc code=end

