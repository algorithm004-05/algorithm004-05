from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if not nums: return []
        # 使用一个数组记录当前值是否被使用过
        used = [False] * len(nums)
        result = []

        def helper(cur):
            if len(cur) == len(nums):
                result.append(cur[:])
            for i in range(len(nums)):
                if not used[i]:
                    cur.append(nums[i])
                    used[i] = True
                    helper(cur)
                    used[i] = False
                    cur.pop()

        helper([])
        return result
