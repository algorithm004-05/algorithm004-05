// Author: liuwufang
// Date: 2019/12/08

#include <vector>
#include <string>
#include <algorithm>
using namespace std;

// https://leetcode-cn.com/problems/longest-valid-parentheses/
// https://leetcode.com/problems/longest-valid-parentheses/

// Question:
// 32. 最长有效括号
// 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

// 示例 1:
// 输入: "(()"
// 输出: 2
// 解释: 最长有效括号子串为 "()"

// Solution 1:
// 动态规划：
// 1. dp[i]         前i个有效扩号的长度
// 2.状态转移方程:
// dp[n] =  dp[i - 2] + 2;      // s[i-1] == '(' && s[i] == ')'
//       = dp[i] = dp[i-1] + 2 + dp[i - 2 -dp[i-1]]; // s[i-1] == ')' && s[i] == ')' && i - 1- dp[i-1] >= 0 && s[i - 1- dp[i-1]] == '('
//          "()()((()))"
// 时间复杂度：O(N)
// 空间复杂度：O(1)

int longestValidParentheses(string s) {
    vector<int> dp(s.size() + 1,0);
    int res = 0;
    for (int i = 1; i < s.size(); ++i) {
        if(s[i-1] == '(' && s[i] == ')'){
            dp[i] = 2 + (i-2 >=0 ? dp[i-2] : 0);
        }else if(s[i-1] == ')' && s[i] == ')' && i - 1- dp[i-1] >= 0 && s[i - 1- dp[i-1]] == '('){
            dp[i] = dp[i-1] + 2 + (i - 2 -dp[i-1]>=0 ? dp[i - 2 -dp[i-1]] : 0);
        }
        res = max(res, dp[i]);
    }

    return res;
}

void leetcode_test_005(void) {
    string str = "babad";
    longestPalindrome(str); // "aba"
    longestPalindrome2(str); // "aba"


}
