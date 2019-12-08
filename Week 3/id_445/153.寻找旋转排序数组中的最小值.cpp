/*
 * @lc app=leetcode.cn id=153 lang=cpp
 *
 * [153] 寻找旋转排序数组中的最小值
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution {
public:
    int findMin(vector<int>& nums) {
        int low=0,high=nums.size()-1;
        
        if(high<0) return -1;
        
        if(nums[0]<nums[nums.size()-1]) return nums[0];
        int mid=0;
        while (high>low)
        {
            mid=(high+low)/2;
            if(nums[mid]<nums[high]){
                high=mid;
                // min=nums[mid];
            }
            else {
                low=mid+1;
                // min=nums[high];
            }
        }
        return nums[low];
        
    }
};
// @lc code=end

