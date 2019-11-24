# class Solution(object):
#     def rob(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         if not nums: 
#             return 0
#         if len(nums) <= 2: 
#             return max(nums)
#         dp = [[None]*2 for _ in nums] 
#         dp[0][0] = 0 
#         dp[0][1] = nums[0] 
#         for i in range(1, len(nums)): 
#             dp[i][0] = max(dp[i-1][0], dp[i-1][1])
#             dp[i][1] = dp[i-1][0] + nums[i]
#         n = len(nums) - 1
#         return max(dp[n][0], dp[n][1]) 

class Solution(object):
    def rob(self, nums):
        cur, pre = 0, 0
        for num in nums:
            cur, pre = max(pre + num, cur), cur
        return cur