/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int movIdx = 0;
        for(int i= 1;i <nums.length;i++){
            if(nums[i]==nums[i-1]){
                movIdx +=1;
            }
            nums[i-movIdx] = nums[i];
        }
        return nums.length-movIdx;
    }
}
// @lc code=end

