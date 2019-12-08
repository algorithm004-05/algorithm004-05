/*
 * @lc app=leetcode.cn id=14 lang=javascript
 *
 * [14] 最长公共前缀
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
  if (!strs.length) return ''
  let ans = strs[0]
  for (let i = 1; i < strs.length; i++) {
    let j = 0
    while (j < ans.length && j < strs[i].length) {
      if (ans.charAt(j) !== strs[i].charAt(j))
        break
      j++
    }
    ans = ans.substr(0, j)
    if (!ans) return ans
  }
  return ans
};
// @lc code=end

