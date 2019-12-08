/*
 * @lc app=leetcode.cn id=52 lang=javascript
 *
 * [52] N皇后 II
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var totalNQueens = function (n) {
  if (!n) return 0
  let col = {}
  let pie = {}
  let nia = {}
  let res = 0
  function dfs(row) {
    if (row == n) {
      res++
      return
    }
    for (let i = 0; i < n; i++) {
      if (!col[i] && !pie[row + i] && !nia[row - i]) {
        col[i] = 1
        pie[row + i] = 1
        nia[row - i] = 1
        dfs(row + 1)
        col[i] = 0
        pie[row + i] = 0
        nia[row - i] = 0
      }
    }
  }
  dfs(0)
  return res
};
// @lc code=end

