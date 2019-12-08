/*
 * @lc app=leetcode.cn id=123 lang=javascript
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  if (!prices.length || prices.length == 1) return 0
  let k = 2
  let dp = []
  for (let i = 0; i < prices.length; i++) {
    dp[i] = [[0], [], []]
  }
  for (let i = 0; i < prices.length; i++) {
    for (let j = k; j >= 1; j--) {
      if (!i) {
        dp[i][j][0] = 0
        dp[i][j][1] = -prices[0]
        continue
      }
      dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i])
      dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i])
    }
  }
  return dp[prices.length - 1][k][0]
};

var maxProfit = function (prices) {
  if (!prices.length || prices.length == 1) return 0
  dp_i_1_0 = 0
  dp_i_1_1 = -prices[0]
  dp_i_2_0 = 0
  dp_i_2_1 = -prices[0]
  for (let i = 1; i < prices.length; i++) {
    dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + prices[i])
    dp_i_2_1 = Math.max(dp_i_1_0 - prices[i], dp_i_2_1)
    dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + prices[i])
    dp_i_1_1 = Math.max(dp_i_1_1, - prices[i])
  }
  return dp_i_2_0
};
maxProfit(
  [3, 3, 5, 0, 0, 3, 1, 4])
// @lc code=end

