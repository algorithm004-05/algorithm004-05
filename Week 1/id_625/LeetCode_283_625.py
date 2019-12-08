#
# @lc app=leetcode.cn id=283 lang=python3
#
# [283] 移动零
#


# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if nums == None or len(nums) <= 1:
            return
        index = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[index], nums[i] = nums[i], nums[index]
                index += 1


# @lc code=end
