/*
 * @lc app=leetcode.cn id=32 lang=javascript
 *
 * [32] 最长有效括号
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function (s) {
  function isValidate(s) {
    let stack = []
    for (let i = 0; i < s.length; i++) {
      if (s[i] == '(') {
        stack.push(')')
      } else {
        if (!stack.length) return false
        stack.pop()
      }
    }
    return stack.length == 0
  }
  let max = 0
  for (let i = 0; i < s.length; i++) {
    for (let j = i + 2; j <= s.length; j += 2) {
      if (isValidate(s.slice(i, j))) {
        max = Math.max(max, j - i)
      }
    }
  }
  return max
};
var longestValidParentheses = function (s) {
  let stack = [-1]
  let max = 0
  for (let i = 0; i < s.length; i++) {
    if (s[i] == '(') {
      stack.push(i)
    } else {
      stack.pop()
      if (!stack.length) {
        stack.push(i)
      } else {
        max = Math.max(max, i - stack[stack.length - 1])
      }
    }
  }
  return max
};
var longestValidParentheses = function (s) {
  let dp = new Array(s.length)
  dp.fill(0)
  let max = 0
  for (let i = 1; i < s.length; i++) {
    if (s[i] == ')') {
      if (s[i - 1] == '(') {
        dp[i] = ((i >= 2) ? dp[i - 2] : 0) + 2
      } else if (i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] == '(') {
        dp[i] = dp[i - 1] + ((i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0) + 2
      }
    }
    max = Math.max(max, dp[i]);
  }
  return max
};
// @lc code=end

