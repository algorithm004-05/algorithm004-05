/*
 * @lc app=leetcode.cn id=213 lang=cpp
 *
 * [213] 打家劫舍 II
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution
{
public:
    int rob(vector<int> &nums)
    {
        if(nums.size()==0) return 0;
        if(nums.size()==1) return nums[0];
        int headCurMax = 0, headPreMax = 0, tailCurMax = 0, tailPreMax = 0, temp = 0;
        int count = nums.size() - 1;
        for (int i = 0; i < count; i++)
        {
            temp = headCurMax;
            headCurMax = headPreMax + nums[i];
            headPreMax = temp;
            headCurMax = headPreMax > headCurMax ? headPreMax : headCurMax;
            temp = tailCurMax;
            tailCurMax = tailPreMax + nums[i + 1];
            tailPreMax = temp;
            tailCurMax = tailPreMax > tailCurMax ? tailPreMax : tailCurMax;
        }
        return tailCurMax>headCurMax?tailCurMax:headCurMax;
    }
};
// @lc code=end
