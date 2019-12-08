# 最大子序和
# 第一遍
# DP:a.重复性：problem(i) = max(sub(i-1)+i,i)  !!!
#    b.定义状态数组：一维dp[i]
#    c.DP方程:dp[i] = max(nums[i], dp[i-1]+nums[i])
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        size = len(nums)
        if size == 0:
            return 0
        dp = [0 for _ in range(size)]

        dp[0] = nums[0]
        for i in range(1, size):
            if dp[i - 1] >= 0:
                dp[i] = dp[i - 1] + nums[i]
            else:
                dp[i] = nums[i]
        return max(dp)

