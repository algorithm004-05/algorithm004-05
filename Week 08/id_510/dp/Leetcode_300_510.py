"""
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1 for _ in range(len(nums))]
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[i] >= nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        print(dp)
        return max(dp)

    def lengthOfLIS1(self, nums: List[int]) -> int:
        lts = [0] * len(nums)
        lts[0] = nums[0]
        _size = 1
        for i in range(1, len(nums)):
            l, r = 0, _size
            while l < r:
                mid = l + ((r - l) >> 1)
                print(l, r)
                if lts[mid] <= nums[i]:
                    l = mid +1
                else:
                    r = mid
            lts[r] = nums[i]
            _size = max(_size, r + 1)
        print(lts)
        return _size


print(Solution().lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]))
