class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        0 :不偷 1: 偷
        dp[i][0] = max(dp[i-1][0],dp[i-1][1])
        dp[i][1] = dp[i-1][0] + nums[i]
        当所需状态信息一维数组无法表达的时候，进行数据升维。
        """
        if not nums: return 0
        dp = [[0, 0] for _ in range(len(nums))]
        dp[0][0] = 0
        dp[0][1] = nums[0]
        for i in range(1, len(nums)):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
            dp[i][1] = dp[i - 1][0] + nums[i]
        return max(dp[-1][0], dp[-1][1])
