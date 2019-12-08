/*
 * @lc app=leetcode.cn id=53 lang=cpp
 *
 * [53] 最大子序和
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution
{
public:
    int maxSubArray(vector<int> &nums)
    {
        if (nums.size() == 0)
            return 0;
        int res = nums[0], temp = 0;
        for (auto num : nums)
        {

            if (temp > 0)
            {
                temp = temp + num;
            }
            else
                temp = num;
            res = res > temp ? res : temp;
        }
        return res;
    }
};
// @lc code=end
