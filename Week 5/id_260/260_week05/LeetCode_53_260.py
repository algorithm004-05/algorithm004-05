# class Solution(object):
#     def maxSubArray(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         size = len(nums)
#         if size == 0:
#             return 0
#         dp = [0 for _ in range(size)]

#         dp[0] = nums[0]
#         for i in range(1, size):
#             if dp[i - 1] >= 0:
#                 dp[i] = dp[i - 1] + nums[i]
#             else:
#                 dp[i] = nums[i]
#         return max(dp)


class Solution:
    def maxSubArray(self, nums):
        size = len(nums)
        if size == 0:
            return 0
        pr = nums[0]
        res = pr
        for i in range(1, size):
            pr = max(nums[i], pr + nums[i])
            res = max(res, pr)
        return res
