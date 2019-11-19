/*
 * @lc app=leetcode.cn id=188 lang=javascript
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
/**
 * @param {number} k
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (k, prices) {
  if (!prices.length || prices.length == 1) return 0
  if (k > prices.length / 2) {
    return (function (prices) {
      let dp_i_0 = 0
      let dp_i_1 = -prices[0]
      for (let i = 1; i < prices.length; i++) {
        dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i])
        dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i])
      }
      return dp_i_0
    })(prices)

  }
  let dp = []
  for (let i = 0; i < prices.length; i++) {
    dp[i] = []
    for (let j = 0; j <= k; j++) {
      dp[i][j] = [0]
    }
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
// @lc code=end

