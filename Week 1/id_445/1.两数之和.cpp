/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */
#include <vector>
#include <map>
using namespace std;
// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res(2,-1);
        map<int,int> m;
        int minus=0;
        for (int i = 0; i < nums.size(); i++)
        {
            minus=target-nums[i];
            if (m.count(minus)>0)
        {
            res[0]=m[minus];
            res[1]=i;
            break;
        }
        m[nums[i]]=i;
        }
        return res;
        
        
        
    }
};
// @lc code=end

