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
var maxProfit = function (prices) {
  if (!prices.length || prices.length == 1) return 0
  let dp = []
  for (let i = 0; i < prices.length; i++) {
    dp[i] = []
  }
  dp[0][0] = 0
  dp[0][1] = -prices[0]
  for (let i = 1; i < prices.length; i++) {
    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])
  }
  return dp[prices.length - 1][0]
};
var maxProfit = function (prices) {
  if (!prices.length || prices.length == 1) return 0
  let dp_i_0 = 0
  let dp_i_1 = -prices[0]
  for (let i = 1; i < prices.length; i++) {
    dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i])
    dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i])
  }
  return dp_i_0
};
// @lc code=end

