/*
 * @lc app=leetcode.cn id=771 lang=javascript
 *
 * [771] 宝石与石头
 */

// @lc code=start
/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function (J, S) {
  let map = {}
  for (const i of J) {
    map[i] = true
  }
  let res = 0
  for (const i of S) {
    if (map[i]) {
      res++
    }
  }
  return res
};
var numJewelsInStones = function (J, S) {
  let res = 0
  for (const i of S) {
    if (J.indexOf(i) !== -1) {
      res++
    }
  }
  return res
};
var numJewelsInStones = function (J, S) {
  let len = S.length
  for (const i of J) {
    S = S.replace(new RegExp(i, 'g'), '')
  }
  return len - S.length
};
// @lc code=end

