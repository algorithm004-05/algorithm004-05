/*
 * @lc app=leetcode.cn id=121 lang=javascript
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  if (!prices.length) return 0
  if (!prices.length == 1) return 0
  //1.分解子问题  第i天无股票 = 前一天有卖掉了 || 前一天 无  第i天有股票 = 前一天没有 今天买 || 前一天有
  //2.状态空间 dp[i][0] 第i天无股票 dp[i][1] 第i天有股票
  //3.DP dp[i][0] = Math.max(dp[i-1][1] + prices[i],dp[i-1][0]) dp[i][1] = Math.max(dp[i-1][1],-prices[i])
  let dp = new Array(prices.length)
  for (let i = 0; i < dp.length; i++) {
    dp[i] = []
  }
  dp[0][0] = 0
  dp[0][1] = -prices[0]
  for (let i = 1; i < prices.length; i++) {
    dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0])
    dp[i][1] = Math.max(dp[i - 1][1], -prices[i])
  }
  return dp[prices.length - 1][0]
};

var maxProfit = function (prices) {
  if (!prices.length) return 0
  if (!prices.length == 1) return 0
  let dp_i_0 = 0
  let dp_i_1 = -prices[0]
  for (let i = 1; i < prices.length; i++) {
    dp_i_0 = Math.max(dp_i_1 + prices[i], dp_i_0)
    dp_i_1 = Math.max(dp_i_1, -prices[i])
  }
  return dp_i_0
};
maxProfit([7, 1, 5, 3, 6, 4])
// @lc code=end

