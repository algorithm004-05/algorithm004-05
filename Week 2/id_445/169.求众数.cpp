/*
 * @lc app=leetcode.cn id=169 lang=cpp
 *
 * [169] 求众数
 */
#include <vector>
#include <algorithm>
#include <map>
using namespace std;
// @lc code=start
class Solution {
public:
///solution 1 sort;
    // int majorityElement(vector<int>& nums) {
    //     int len=nums.size();
    //     sort(nums.begin(),nums.end());
    //     return nums[len/2];
    // }
    //solution 1 map faster
    int majorityElement(vector<int>& nums) {
        int mid=nums.size()/2+1;
        map<int,int> count;
        for (auto  n: nums)
        {
            count[n]++;
            if(count[n]==mid) return n;
        }
        
        return 0;
    }
};
// @lc code=end

