# 283. 移动零
class Solution:
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        i = 0
        for num in nums:
            if num != 0:
                nums[i] = num
                i += 1
        for j in range(i, len(nums)):
            nums[j] = 0

        # k = 0
        # for i in xrange(len(nums)):
        #     if nums[i] != 0:
        #         nums[i], nums[k] = nums[k], nums[i]
        #         k += 1  