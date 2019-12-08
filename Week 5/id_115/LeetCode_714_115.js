/*
 * @lc app=leetcode.cn id=714 lang=javascript
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @param {number} fee
 * @return {number}
 */
var maxProfit = function (prices, fee) {
  if (!prices.length || prices.length == 1) return 0
  let dp_i_0 = 0
  let dp_i_1 = -prices[0] - fee
  for (let i = 1; i < prices.length; i++) {
    dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i])
    dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i] - fee)
  }
  return dp_i_0
};
// @lc code=end

