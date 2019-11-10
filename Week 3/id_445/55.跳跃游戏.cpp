/*
 * @lc app=leetcode.cn id=55 lang=cpp
 *
 * [55] 跳跃游戏
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution {
public:
//solution 1 
    // bool canJump(vector<int>& nums) {
    //     int maxStep=0;
        
    //     for (int i = 0; i < nums.size(); i++)
    //     {
    //         if(i>maxStep) return false;
    //         maxStep=max(maxStep,i+nums[i]);
    //     }
    //     return true;
        
    // }
//solution 2 beats 99.92%
        bool canJump(vector<int>& nums) {
        int maxStep=0;
        
        for (int i = 0; i < nums.size(); i++)
        {
            if(i>maxStep) return false;
            if(i+nums[i]>nums.size() ) return true;
            maxStep=max(maxStep,i+nums[i]);
        }
        return true;
        
    }
};
// @lc code=end

