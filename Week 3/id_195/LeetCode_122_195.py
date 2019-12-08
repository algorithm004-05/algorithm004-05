class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxprice = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i-1]:
                maxprice += prices[i] - prices[i-1]
        return maxprice