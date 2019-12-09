class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        dp[i]=max(0, dp[i]) + dp[i-1]
        """
        dp = nums
        for i in range(1, len(nums)):
            dp[i] = max(dp[i - 1] + dp[i], dp[i])
        return max(dp)
