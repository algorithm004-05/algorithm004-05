/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        if(nums.length == 0 ) return -1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                lo = mid + 1;
            } 
            else if (target > nums[mid] && target < nums[0]) { //[5,1,3]
                lo = mid + 1;                                  // 3                
            } 
            else {
                hi = mid;
            }
        }

        return nums[lo] == target ? lo : -1;
    }
}
// @lc code=end

