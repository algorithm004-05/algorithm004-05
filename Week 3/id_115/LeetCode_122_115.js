/*
 * @lc app=leetcode.cn id=122 lang=javascript
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  let i = 0
  let res = 0
  while (i < prices.length) {
    if (prices[i] < prices[i + 1]) {
      res += prices[i + 1] - prices[i]
    }
    i++
  }
  return res
};
// @lc code=end

