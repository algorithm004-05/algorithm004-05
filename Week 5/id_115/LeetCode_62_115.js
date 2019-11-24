/*
 * @lc app=leetcode.cn id=62 lang=javascript
 *
 * [62] 不同路径
 */

// @lc code=start
/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function (m, n) {
  let arr = []
  for (let i = 0; i < m; i++)arr[i][0] = 1
  for (let i = 0; i < n; i++)arr[0][i] = 1
  for (let i = 1; i < m; i++) {
    for (let j = 1; j < n; j++) {
      arr[i][j] = arr[i - 1][j] + arr[i][j - 1]
    }
  }
  return arr[m][n]
};
var uniquePaths = function (m, n) {
  let cur = new Array(n)
  cur.fill(1)
  for (let i = 1; i < m; i++) {
    for (let j = 1; j < n; j++) {
      cur[j] = cur[j - 1] + cur[j];
    }
  }
  return cur[n - 1]
}
// @lc code=end

