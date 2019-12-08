/*
 * @lc app=leetcode.cn id=115 lang=cpp
 *
 * [115] 不同的子序列
 */

// @lc code=start
class Solution {
public:
    int numDistinct(string s, string t) {
        int m = s.length(), n = t.length();
        long dp[n + 1] = {0};
        long pre, tmp;
        for(int i = 0; i <= m; i++)
            for(int j = 0; j <= n; j++)
            {
                tmp = dp[j];
                if(j == 0) dp[j] = 1;
                else if(i == 0) dp[j] = 0;
                else if(s[i - 1] == t[j - 1]) dp[j] += pre;
                pre = tmp;
            }
        return dp[n];
    }
};


// @lc code=end

