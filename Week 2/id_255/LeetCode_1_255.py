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
        dicts={}
        for i,item in enumerate(nums):
            if item in dicts:
                return [dicts[item],i]
            else:
                dicts[target-item]=i