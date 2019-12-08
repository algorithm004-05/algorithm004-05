/*
 * @lc app=leetcode.cn id=153 lang=cpp
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public:
    int findMin(vector<int>& nums) {
        if (nums.empty()) return -1;
        int inversePoint  = 0 ;
        int left = 0, right = nums.size() - 1;
        while(left <= right){
            int mid = left + (right -left)/2;
            if (nums[mid] <= nums[right] && nums[mid] >= nums[left]){
                return  nums[left];
                break;
            }
            if (nums[mid] >= nums[left] )
                left = mid + 1;
            else
                right = mid ;
        }
        return -1;
    }
};
// @lc code=end

