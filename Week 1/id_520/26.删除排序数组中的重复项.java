/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {


        // // 方法一,快慢指针
        // if(nums.length == 0) return 0;
        // int after_numsLength = 0;
        // for(int i = 0; i < nums.length; i++){
        //     if(nums[after_numsLength] != nums[i]){
        //         after_numsLength++;
        //         nums[after_numsLength] = nums[i];
        //     }
        // }
        // return after_numsLength+1;
     
        
        // 方法二，参考leetCode高票解法
        // 用来表示删除重复项之后数组元素个数的i，减1，才是当前遍历到的数组的下标
        int i = 0;
        for (int n : nums) {
            if (i == 0 || n != nums[i-1]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
// @lc code=end

