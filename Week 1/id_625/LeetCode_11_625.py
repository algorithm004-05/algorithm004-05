#
# @lc app=leetcode.cn id=11 lang=python3
#
# [11] 盛最多水的容器
#


# @lc code=start
class Solution:
    def maxArea(self, height: List[int]) -> int:
        # 枚举法
        water = 0
        for L in range(len(height)):
            for R in range(L + 1, len(height)):
                water = max(water, (R - L) * min(height[L], height[R]))
        return water

        # 左右指针法
        L, R, width, water = 0, len(height) - 1, len(height) - 1, 0
        for w in range(width, 0, -1):
            if height[L] < height[R]:
                water, L = max(water, w * height[L]), L + 1
            else:
                water, R = max(water, w * height[R]), R - 1
        return water


# @lc code=end
