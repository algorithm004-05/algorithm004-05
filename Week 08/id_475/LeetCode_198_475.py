# 打家劫舍
# DP
# 法一：一维数组
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        # 创建数组
        dp = [0] * len(nums)
        # 初始化数组
        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1])
        # 填充剩余位置
        for i in range(2,len(nums)):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])  # DP方程
        return dp[-1]

# 法二：二维数组
# 自己写的
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        # 创建数组
        dp = [ [0] * 2 for _ in range(len(nums))]
        # 初始化数组
        dp[0][1] = nums[0]
        dp[1][0] = nums[0]
        dp[1][1] = nums[1]
        # 填充剩余位置
        for i in range(2,len(nums)):
            dp[i][0] = max(dp[i-1][1],dp[i-1][0])
            dp[i][1] = max(dp[i-2][1],dp[i-2][0]) + nums[i]
        return max(dp[-1])

# 别人写的
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums: # 空时直接返回 0
            return 0
        if len(nums) <= 2: # 元素个数小于 2 时的最基本情况
            return max(nums)
        dp = [[None]*2 for _ in nums] # 初始化数组
        dp[0][0] = 0 # 第 1 天未抢
        dp[0][1] = nums[0] # 第 1 天抢劫了
        for i in range(1, len(nums)): # 从第二天开始择优
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]
        n = len(nums) - 1
        return max(dp[n][0], dp[n][1]) # 从最后一天选择出 抢了最后一天 和 没抢最后一天 最大的
