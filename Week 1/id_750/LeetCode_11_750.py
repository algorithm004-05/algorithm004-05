"""
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

示例:

输入: [1,8,6,2,5,4,8,3,7]
输出: 49
"""

from typing import List


class Solution:
    # 双指针思想， 从左右同时遍历，直至两个指针遇见，找到合适的结果输出
    def maxArea(self, height: List[int]) -> int:
        maxarea = 0
        left = 0
        right = len(height) - 1

        while left < right:
            maxarea = max(maxarea, min(height[left], height[right]) * (right - left))
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return maxarea


if __name__ == '__main__':
    solution = Solution()

    nums = [1, 8, 6, 2, 5, 4, 8, 3, 7]

    result = solution.maxArea(nums)

    print(result)
