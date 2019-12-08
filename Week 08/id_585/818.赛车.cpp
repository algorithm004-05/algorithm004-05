/*
 * @lc app=leetcode.cn id=818 lang=cpp
 *
 * [818] 赛车
 */

// @lc code=start
class Solution
{
public:
    int dp[10001];
    int racecar(int t)
    {
        {
            if (dp[t] > 0)
                return dp[t];
            int n = floor(log2(t)) + 1, res;
            if (1 << n == t + 1)
                dp[t] = n;
            else
            {
                dp[t] = racecar((1 << n) - 1 - t) + n + 1;
                for (int m = 0; m < n - 1; ++m)
                    dp[t] = min(dp[t], racecar(t - (1 << (n - 1)) + (1 << m)) + n + m + 1);
            }
            return dp[t];
        }
    }
};
// @lc code=end

