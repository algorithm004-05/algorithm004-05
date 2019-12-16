// Author: liuwufang
// Date: 2019/12/08

#include <vector>
#include <string>
#include <algorithm>
using namespace std;

// https://leetcode-cn.com/problems/longest-palindromic-substring/
// https://leetcode.com/problems/longest-palindromic-substring/

// Question:
// 5. 最长回文子串
// 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

// 示例 1：

// 输入: "babad"
// 输出: "bab"
// 注意: "aba" 也是一个有效答案。


// Solution 1:
// 动态规划：
// 1. dp[i][j] 从i..j是否是回文串
// 2. dp[i][j] =    s[i] == s[j] && dp[i + 1][j - 1]
//                  s[i] == s[j] && j - i < 2 // 单个字符

// 时间复杂度:O(N^2)
// 空间复杂度:O(N^2)
string longestPalindrome(string s) {
    // 1.dp define
    const int n = s.length();
    if (n < 2) return s;
    
    string res = "";
    vector<vector<int>> dp(n, vector<int>(n));
    for (int i = n - 1; i >= 0; --i) {
        for (int j = i; j < n; ++j) {
            // 2. dp 方程
            dp[i][j] = (s[i] == s[j]) && ((j - i < 2) || dp[i + 1][j - 1]);
            
            // 3. update max res
            if (dp[i][j] && (j - i + 1) > res.length()) {
                res = s.substr(i, j - i + 1);
            }
        }
    }

    return res;
}


// Solution 2:
// 中心扩展法：
// 1.从0遍历一次字符串 
// 2.循环判断当前字符和后一字符是否相等，去重
// 3.左右两侧扩展值是否相等，相同则继续扩展
// 4.优化： 当n - i <= max_len / 2，已经全部扩展完毕，推出

// 时间复杂度:O(N^2)
// 空间复杂度:O(1)
string longestPalindrome2(string s) {
    // 1.dp define
    const int n = s.length();
    if (n < 2) return s;
    
    string res = "";
    int start = 0, max_len = 1;
    for (int i = 0; i < n;) {
        if (n - i <= max_len / 2) break;
        int j = i, k = i;
        // skip duplicate chars
        while (k < n - 1 && s[k] == s[k + 1]) k++;
        i = k + 1;
        while (k < n - 1 && j > 0 && s[k + 1] == s[j - 1]) {
            ++k;
            --j;
        }
        int cur_len = k - j + 1;
        if (cur_len > max_len) {
            max_len =  cur_len;
            start = j;
        }
    }

    return s.substr(start, max_len);
}

void leetcode_test_005(void) {
    string str = "babad";
    longestPalindrome(str); // "aba"
    longestPalindrome2(str); // "aba"


}
