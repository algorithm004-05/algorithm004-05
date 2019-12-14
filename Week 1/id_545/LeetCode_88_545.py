## 合并两个有序数组
# 方法一：合并后排序 时间：O( (m+n)log(m+n) ) 空间： O(1)
# class Solution:
#     def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
#         i = 0
#         while i < n:
#             nums1[m+i] = nums2[i]
#             i += 1
#         nums1.sort()

###############################################################################################

# 方法二： 使用切片 时间：O( (m+n)log(m+n) ) 空间： O(1)
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        nums1[m:] = nums2[:n]
        nums1.sort()

###############################################################################################

# 方法三： 双指针 前往后  时间：O(n + m)O(n+m) 空间：O(m)
# class Solution:
#     def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
#         arr = nums1[:m]
#         nums1[:] = []
#         i = 0
#         j = 0
#         while i< m and j < n:
#             if arr[i] < nums2[j]:
#                 nums1.append(arr[i])
#                 i += 1
#             else:
#                 nums1.append(nums2[j])
#                 j += 1
        
#         if i < m:
#             nums1[i+j:] = arr[i:]
#         if j < n:
#             nums1[i+j:] = nums2[j:]