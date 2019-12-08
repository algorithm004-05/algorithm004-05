# 1. 两数之和
class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # n=len(nums)
        # for i in range(n):
        #     result=target-nums[i]
        #     for j in range(i+1,n):
        #         if result==nums[j]:
        #             return [i,j]
        dic = {}
        for i, num in enumerate(nums):
            if num in dic:
                return [dic[num], i]
            else:
                dic[target - num] = i