class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        min_price = float("inf")
        for p in prices:
            if min_price < p:
                max_profit += p - min_price
                min_price = p
            else:
                min_price = p
        return max_profit
