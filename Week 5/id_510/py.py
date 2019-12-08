class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = [[[0 for _ in range(2)] for _ in range(2)]
        for _ in range(len(prices))]
        #天数 交易次数 拥有股票数量
        dp[0][1][0], dp[0][1][1], dp[0][0][0] = 0, -prices[0], 0
        for i in range(1, len(prices)):
            for k in range(1, 2):
                dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
                dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
        return dp[len(prices)-1][k][0]
