/*
 * @lc app=leetcode.cn id=91 lang=javascript
 *
 * [91] 解码方法
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function (s) {
  if (!s.length) return 0
  if (s.length == 1) return 1
  let dp = new Array(s.length)
  dp[0] = 1
  dp[1] = 1
  for (let i = 1; i < s.length; i++) {
    if (s[i - 1] == 0) {
      if (s[i] == 0) return 0
      dp[i + 1] = dp[i]
    } else {
      if (s[i] == 0) {
        if (Number(s[i - 1] * 10) + Number(s[i]) <= 26) {
          dp[i + 1] = dp[i - 1]
        } else {
          return 0
        }
      } else {
        if (Number(s[i - 1] * 10) + Number(s[i]) <= 26) {
          dp[i + 1] = dp[i] + dp[i - 1]
        } else {
          dp[i + 1] = dp[i]
        }
      }
    }
  }
  return dp[s.length]
};
numDecodings('123465')
// @lc code=end

