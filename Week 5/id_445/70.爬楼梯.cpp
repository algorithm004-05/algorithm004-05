/*
 * @lc app=leetcode.cn id=70 lang=cpp
 *
 * [70] 爬楼梯
 */
#include <vector>
using namespace std;

// @lc code=start
class Solution
{
public:
    //solution 1
    // int climbStairs(int n)
    // {
    //     int memo[n + 1];
    //     for (int i = 0; i < n + 1; i++)
    //     {
    //         memo[i] = 0;
    //     }

    //     recur(0, n, memo);
    //     return memo[0];
    // }
    // int recur(int i, int n, int memo[])
    // {
    //     if (i > n)
    //     {
    //         return 0;
    //     }
    //     if (i == n)
    //     {
    //         return 1;
    //     }
    //     if (memo[i] > 0)
    //         return memo[i];
    //     memo[i] = recur(i + 1, n, memo) + recur(i + 2, n, memo);
    //     return memo[i];
    // }

    //solution 2
    int climbStairs(int n)
    {
        vector<int> memo(n + 1, 0);

        recur(0, n, memo);
        return memo[0];
    }
    int recur(int i, int n, vector<int> &memo)
    {
        if (i > n)
            return 0;
        if (i == n)
            return 1;

        if (memo[i] > 0)
            return memo[i];
        memo[i] = recur(i + 1, n, memo) + recur(i + 2, n, memo);
        return memo[i];
    }
};
// @lc code=end
