## 两数之和
# 方法一： 暴力法 时间：O(n^2) 空间：O(1)
# class Solution:
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         for i in range(0, len(nums)-1):
#             for j in range(i+1, len(nums)):
#                 if nums[i] + nums[j] == target:
#                     return [i, j]

#######################################################################

# 方法二： hash Map 时间：O(n) 空间：O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dct = dict()
        for i in range(0, len(nums)):
            val = target - nums[i]
            if val in dct:
                return [dct[val], i]
            
            dct[nums[i]] = i