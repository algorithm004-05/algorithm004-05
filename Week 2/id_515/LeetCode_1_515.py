#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        subMap = {}
        for i, n in enumerate(nums):
            r = subMap.get(target - n)
            if r is not None: return [ r, i]
            subMap[n] = i
