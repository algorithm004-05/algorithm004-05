class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if prices == []:
            return 0
        profit, start, end, prev = 0, 0, None, prices[0]
        for i in range(1,len(prices)):
            if prices[i] >= prev:
                end = i
            else:
                if end:
                    profit = profit + prices[end]-prices[start]
                start,end = i,None
            prev = prices[i]
        if end:
            profit = profit + prices[end]-prices[start]
        return profit