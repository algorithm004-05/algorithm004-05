# @author:leacoder 
# @des: 动态规划 买卖股票的最佳时机 IV(通用型) 


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        if n <= 1: return 0
        if k > int(n / 2):  # 会超时
            # k = int(n/2)
            return self.greedy(prices)  # 使用贪心

        maxprof = 0
        profit = [[[0 for _ in range(2)] for _ in range(k + 1)] for _ in
                  range(0, len(prices))]  # DP[ii][kk][0] 第ii天完成kk次操作无股票 DP[ii][kk][1]第ii天完成kk次操作有股票 prices[ii] 第ii天股票价格

        for i in range(0, k + 1):
            profit[0][i][0] = 0  # 第 1 天 操作i 次 没有股票，所以初始值为 0
            profit[0][i][1] = - prices[0]  # 第 1 天 操作i 次 有股票， 所以初始值为 - prices[ii]

        for ii in range(1, len(prices)):  # 天数
            for kk in range(0, k + 1):  # 交易次数
                if kk == 0:  #
                    profit[ii][kk][0] = profit[ii - 1][kk][0]  # 0 次交易 今天利润 == 前一天利润
                else:
                    # 今天完成kk次操作无股票  max(前一天无股票今天不交易，前一天有股票今天卖出)  买卖一次算一笔交易 以买入算一次交易 故 profit[ii - 1][kk ][1] + prices[ii]
                    profit[ii][kk][0] = max(profit[ii - 1][kk][0], profit[ii - 1][kk][1] + prices[ii])
                # 今天完成kk次操作有股票  max(前一天有股票今天不交易，前一天无股票今天买入) 以买入算一次交易
                profit[ii][kk][1] = max(profit[ii - 1][kk][1], profit[ii - 1][kk - 1][0] - prices[ii])
                maxprof = max(maxprof, profit[ii][kk][0])
        return maxprof

    def greedy(self, prices: List[int]) -> int:
        max = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                max += prices[i] - prices[i - 1]
        return max