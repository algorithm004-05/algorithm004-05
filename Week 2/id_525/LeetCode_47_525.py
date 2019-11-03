from typing import List


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        '''
        回溯=DFS+剪枝+状态清除
        :param nums:
        :return:
        '''
        result = []
        nums.sort()
        used = [False] * len(nums)

        def helper(cur):
            if len(cur) == len(nums):
                result.append(cur[:])
                return
            for i in range(len(nums)):
                if not used[i]:
                    # 进行剪枝操作，看起来容易，实现起来很不容易
                    if i > 0 and nums[i - 1] == nums[i] and not used[i - 1]:
                        continue
                    cur.append(nums[i])
                    used[i] = True
                    helper(cur)
                    cur.pop()
                    used[i] = False

        helper(0, [])
        return result
