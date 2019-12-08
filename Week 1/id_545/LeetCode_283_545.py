## 移动零
# 统计法 时间：O(n) 空间：O(1)
# class Solution:
#     def moveZeroes(self, nums: List[int]) -> None:
#         n = 0
#         for i in range(0, len(nums)):
#             if nums[i] != 0:
#                 nums[n] = nums[i]
#                 n += 1
        
#         while n < len(nums):
#             nums[n] = 0
#             n += 1

##########################################################

# 快慢指针 时间：O(n) 空间：O(1)
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        s = 0
        for f in range(0, len(nums)):
            if nums[f] != 0:
                nums[s], nums[f] = nums[f], nums[s]
                s += 1