# 买卖股票的最佳时机
#法一：暴力法 超时
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        res = 0
        # 填充数组
        for i in range(len(prices)):
            for j in range(i+1,len(prices)):
                res = max(res,prices[j] - prices[i])
        return res