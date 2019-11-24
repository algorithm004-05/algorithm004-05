/*
 * @lc app=leetcode.cn id=198 lang=cpp
 *
 * [198] 打家劫舍
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution {
public:
    int rob(vector<int>& nums) {
        int current=0,previous=0,temp=0;
        for(auto num:nums){
            temp=current;
            current=num+previous;
            previous=temp;
            current=previous>current?previous:current;
        }
        return current;
        
    }
};
// @lc code=end

