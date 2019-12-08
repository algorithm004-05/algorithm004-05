## 旋转数组
# 方法一： 暴力法， 循环嵌套   时间：O(k*n) 空间：O(1)
# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         n = len(nums) - 1
#         j = 0
#         while j < k:
#             i = n
#             temp = nums[n]
#             while i > 0:
#                 nums[i] = nums[i-1]
#                 i -= 1
#             nums[0] = temp
#             j += 1

#################################################################

#  方法二：拆分对调  时间：O(n) 空间：O(n)
# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         split_index = len(nums) - k
#         front_arr = nums[:split_index]
#         after_arr = nums[split_index:]
#         for i, num in enumerate(after_arr + front_arr):
#             nums[i] = num

#################################################################

# 方法三： 反转法 时间：O(n) 空间：O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k %= len(nums)
        self.reversal(nums, 0, len(nums)-1)
        self.reversal(nums, 0, k-1)
        self.reversal(nums, k, len(nums)-1)
    
    def reversal(self, nums: List[int], start: int, end: int) -> None:
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1