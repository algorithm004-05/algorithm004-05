/*
 * @lc app=leetcode.cn id=26 lang=cpp
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
public:
    int removeDuplicates(vector<int> &nums) {
        if (nums.empty()) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.size(); j++)
        {
            if (nums[j] != nums[i])
            {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
};
// @lc code=end
