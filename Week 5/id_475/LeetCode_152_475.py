# 乘积最大子序列（对比LT53：最大子序和）要记录最大值和最小值
# 第一遍
# DP：a.重复性
#     b.定义状态数组：一维
#     c.DP方程：dp[i] = max(nums[i] * pre_max, nums[i] * pre_min, nums[i])
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums: return 
        res = nums[0]
        pre_max = nums[0]
        pre_min = nums[0]
        for num in nums[1:]:
            cur_max = max(pre_max * num, pre_min * num, num)
            cur_min = min(pre_max * num, pre_min * num, num)
            res = max(res, cur_max)
            pre_max = cur_max
            pre_min = cur_min
        return res

