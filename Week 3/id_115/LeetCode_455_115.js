/*
 * @lc app=leetcode.cn id=455 lang=javascript
 *
 * [455] 分发饼干
 */

// @lc code=start
/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function (g, s) {
  let i = 0, j = 0;
  let res = 0
  g.sort((a, b) => {
    return a - b
  })
  s.sort((a, b) => {
    return a - b
  })
  while (i < g.length && j < s.length) {
    if (g[i] <= s[j]) {
      res++
      i++
      j++
    } else {

      j++
    }
  }
  return res
};
// @lc code=end

