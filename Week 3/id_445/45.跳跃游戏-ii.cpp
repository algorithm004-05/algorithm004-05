/*
 * @lc app=leetcode.cn id=45 lang=cpp
 *
 * [45] 跳跃游戏 II
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution
{
public:
    //solution 1
    // int jump(vector<int> &nums)
    // {
    //     int begin = 0, end = 1, temp = 0, res = 0;
    //     while (end < nums.size())
    //     {
    //         temp=0;
    //         for (int i = begin; i < end; i++)
    //         {
    //             temp = max(temp, i + nums[i]);
    //         }
    //         begin = end;
    //         end = temp + 1;
    //         res++;
    //     }
    //     return res;
    // }

    //solution 2
    int jump(vector<int> &nums)
    {
        int end = 0, temp = 0, res = 0;

        for (int i = 0; i < nums.size()-1; i++)
        {
            temp = max(temp, i + nums[i]);

            if (i == end)
            {
                res++;
                end=temp;
            }
        }

        return res;
    }
};
// @lc code=end
