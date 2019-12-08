class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        _zero = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                if i != _zero:
                    nums[_zero], nums[i] = nums[i], nums[_zero]
                _zero += 1
