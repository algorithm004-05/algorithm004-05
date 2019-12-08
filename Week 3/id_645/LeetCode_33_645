/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int hi = nums.length -1;
        int lo = 0;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(nums[lo]<=nums[mid]&&(target>nums[mid]||target<nums[lo])){
                lo = mid+1;
            }else if(target>nums[mid]&&target<nums[lo]){
                lo = mid+1;
            }else{
                hi = mid;
            }
        }
        return lo==hi&&nums[lo]==target?lo:-1;
    }
}
// @lc code=end

