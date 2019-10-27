/*
 * @lc app=leetcode.cn id=66 lang=cpp
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
public:
    vector<int> plusOne(vector<int> &digits)
    {
        for (int i = digits.size(); i > 0; i--)
        {
            if (digits[i - 1] == 9)
            {
                digits[i - 1] = 0;
            }
            else
            {
                ++digits[i - 1];
                return digits;
            }
        }
        digits[0] = 1;
        digits.push_back(0);
        return digits;
    }
};
// @lc code=end

