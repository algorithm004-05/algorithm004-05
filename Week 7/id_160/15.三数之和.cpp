/*
 * @lc app=leetcode.cn id=15 lang=cpp
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution
{
public:
    vector<vector<int>> threeSum(vector<int> &nums)
    {
        // vector<vector<int>> result;
        // sort(nums.begin(), nums.end());
        // for (int i = 0; i < nums.size() && nums[i] <= 0; i++)
        // {
        //     if (i > 0 && nums[i] == nums[i - 1])
        //         continue;
        //     int j = i + 1;
        //     int k = nums.size() - 1;
        //     while (j < k)
        //     {
        //         int sums = nums[i] + nums[j] + nums[k];
        //         if (sums > 0)
        //             k--;
        //         else if (sums < 0)
        //             j++;
        //         else
        //         {
        //             result.push_back(vector<int>{nums[i], nums[j], nums[k]});
        //             j++;
        //             while (j < k && nums[j] == nums[j - 1])
        //                 j++;
        //         }
        //     }
        // }
        // return result;
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        if (nums.empty() || nums.back() < 0 || nums.front() > 0)
            return res;
        for (int k = 0; k < nums.size(); k++)
        {
            if (nums[k] > 0)
                break;
            if (k > 0 && nums[k] == nums[k - 1])
                continue;
            int target = 0 - nums[k], i = k + 1, j = nums.size() - 1;
            while (i < j)
            {
                if (nums[i] + nums[j] == target)
                {
                    res.push_back({nums[k], nums[i], nums[j]});
                    while (i < j && nums[i] == nums[i + 1])
                        i++;
                    while (i < j && nums[j] == nums[j - 1])
                        j--;
                    i++;
                    j--;
                }
                else if (nums[i] + nums[j] < target)
                    i++;
                else
                    j--;
            }
        }
        return res;
    }
};
// @lc code=end
