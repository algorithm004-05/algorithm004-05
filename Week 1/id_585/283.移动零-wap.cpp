/*
 * @lc app=leetcode.cn id=283 lang=cpp
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int j = 0;
        for (int i = 0 ; i<nums.size(); i++ ){
            if(nums[i] != 0){
            swap(nums[j] , nums[i]);
            j++;
            }
        }
    }
};
// @lc code=end

