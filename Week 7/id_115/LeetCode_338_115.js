/*
 * @lc app=leetcode.cn id=338 lang=javascript
 *
 * [338] 比特位计数
 */

// @lc code=start
/**
 * @param {number} num
 * @return {number[]}
 */
var countBits = function (num) {
  let res = []
  for (let i = 0; i <= num; i++) {
    res.push(bits(i))
  }
  return res
  function bits(n) {
    let res = 0
    while (n) {
      res++
      n &= (n - 1)
    }
    return res
  }
};
// @lc code=end

