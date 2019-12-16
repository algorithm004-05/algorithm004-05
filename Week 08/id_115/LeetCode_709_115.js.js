/*
 * @lc app=leetcode.cn id=709 lang=javascript
 *
 * [709] 转换成小写字母
 */

// @lc code=start
/**
 * @param {string} str
 * @return {string}
 */
var toLowerCase = function (str) {
  let res = ''
  for (let i = 0; i < str.length; i++) {
    if (str.charCodeAt(i) >= 65 && str.charCodeAt(i) <= 90) {
      res += String.fromCharCode(str.charCodeAt(i) + 32)
    } else {
      res += str[i]
    }
  }
  return res
};

// 大写变小写、小写变大写 : ASCII码 ^= 32
// 大写变小写、小写变小写 : ASCII码 |= 32
// 小写变大写、大写变大写 : ASCII码 &= -33

var toLowerCase = function (str) {
  let res = ''
  for (let i = 0; i < str.length; i++) {
    res += String.fromCharCode(str.charCodeAt(i) | 32)
  }
  return res
};
// @lc code=end

