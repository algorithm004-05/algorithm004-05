/*
 * @lc app=leetcode.cn id=8 lang=javascript
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function (str) {
  if (!str) return 0
  str = str.trim()
  let reg = new RegExp(/^[+|-]?\d+/g)
  if (!reg.test(str)) return 0
  let num = str.match(reg)[0]
  if (num > Math.pow(2, 31) - 1) {
    return Math.pow(2, 31) - 1
  }
  if (num < - Math.pow(2, 31)) {
    return Math.pow(2, 31)
  }
  return num
};
// @lc code=end

