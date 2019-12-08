/*
 * @lc app=leetcode.cn id=191 lang=javascript
 *
 * [191] 位1的个数
 */

// @lc code=start
/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function (n) {
  let count = 0
  for (let i = 0; i < 32; i++) {
    if (n & 1) {
      count++
    }
    n = n >> 1
  }
  return count
};
var hammingWeight = function (n) {
  let count = 0
  while (n) {
    count++
    n = n & (n - 1)
  }
  return count
};
var hammingWeight = function (n) {
  let count = 0
  while (n) {
    if (n % 2) {
      count++
    }
    n = Math.floor(n / 2)
  }
  return count
};
// @lc code=end

