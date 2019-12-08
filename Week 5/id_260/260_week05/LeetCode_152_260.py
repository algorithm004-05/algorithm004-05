# class Solution(object):
#     def maxProduct(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         if not nums: return 
#         res = nums[0]
#         pre_max = nums[0]
#         pre_min = nums[0]
#         for num in nums[1:]:
#             cur_max = max(pre_max * num, pre_min * num, num)
#             cur_min = min(pre_max * num, pre_min * num, num)
#             res = max(res, cur_max)
#             pre_max = cur_max
#             pre_min = cur_min
#         return res

class Solution:
    def maxProduct(self, nums):
        mi = ma = res = nums[0]
        for i in range(1, len(nums)):
            if nums[i] < 0: mi, ma = ma, mi
            ma = max(ma * nums[i], nums[i])
            mi = min(mi * nums[i], nums[i])
            res = max(res, ma)
        return res 
