// Author: liuwufang
// Date: 2019/10/20

#include <vector>
#include <string>
#include <algorithm>
using namespace std;

// https://leetcode-cn.com/problems/climbing-stairs/
// https://leetcode.com/problems/climbing-stairs/

// Question:
// 70. 爬楼梯
// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

// Solution:
// 思路1: DP
// 1.子问题：a[i] = a[i - 1] + a[i - 2]
// 2.状态空间：dp[i] 表示爬i阶不同方法的总数
// 3.状态转移方程:
// dp[i] =  i;      // i <= 2
//       = dp[i - 1] + dp[i - 2]; // i > 2
// 时间复杂度：O(N)
// 空间复杂度：O(N)

int climbStairs1(int n) {
    if (n <= 2) return n;
    vector<int> dp(n + 1, 0);
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; ++i) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    
    return dp[n];
}

// 思路2: DP
// 使用变量代替数组记忆
// 时间复杂度：O(N)
// 空间复杂度：O(1)
int climbStairs2(int n) {
    if (n <= 2) return n;
    int a = 1;
    int b = 2;
    int ret = 0;
    for (int i = 3; i <= n; ++i) {
        ret = a + b;
        a = b;
        b = ret;
    }

    return ret;
}

void leetcode_test_070(void) {
    climbStairs1(10); // 89
    climbStairs2(10); // 89
}