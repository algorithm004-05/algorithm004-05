/*
 * @lc app=leetcode.cn id=22 lang=javascript
 *
 * [22] 括号生成
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
  let res = []
  function helper(left, right, str) {
    if (left + right == 2 * n) {
      res.push(str)
      return
    }
    if (left < n) {
      helper(left + 1, right, str + '(')
    }
    if (left > right) {
      helper(left, right + 1, str + ')')
    }


  }
  helper(0, 0, '')
  return res
};
// @lc code=end

