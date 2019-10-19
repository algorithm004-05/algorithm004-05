/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        map<int, int> mymap;
        vector<int> res{1, 1};
        for (int i = 0; i < nums.size(); i++)
        {

        if (mymap.count(target - nums[i])&&mymap[target - nums[i]] != i)
            {
                res[0] = mymap[target - nums[i]];
                res[1] = i;
              //为什么不能在这里用return？
              //  return res;
                break;
            }
            if (!mymap.count(nums[i]))
            mymap.insert(pair<int, int>(nums[i], i));
        }
        return res;
    }
};
// @lc code=end

