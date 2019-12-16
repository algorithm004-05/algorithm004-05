/*
 * @lc app=leetcode.cn id=387 lang=javascript
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
  let map = {}
  for (let i = 0; i < s.length; i++) {
    if (!map[s[i]]) map[s[i]] = { val: 0, index: i }
    map[s[i]].val++
  }
  for (const key of Object.keys(map)) {
    if (map[key].val == 1) {
      return map[key].index
    }
  }
  return -1
};
var firstUniqChar = function (s) {
  for (const i of s) {
    if (s.indexOf(i) == s.lastIndexOf(i)) return s.indexOf(i)
  }
  return -1
};
// @lc code=end

