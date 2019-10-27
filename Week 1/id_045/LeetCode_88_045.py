# @author:leacoder
# @des:  合并后排序  合并两个有序数组
# 时间复杂度 : O((n + m)log(n + m))
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        nums1[:] = sorted(nums1[:m] + nums2)



# @author:leacoder
# @des:  双指针 从前往后 合并两个有序数组
# 时间复杂度 : O(n + m)

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        nums1_copy = nums1[:m] 
        nums1[:] = []
        # 双指针 从前往后
        p1 = 0 
        p2 = 0

        while p1 < m and p2 < n:
            if nums1_copy[p1] < nums2[p2]: 
                nums1.append(nums1_copy[p1])
                p1 += 1
            else:
                nums1.append(nums2[p2])
                p2 += 1
        # 处理 剩余元素, 只有一个条件能满足
        if p1 < m: 
            nums1[p1 + p2:] = nums1_copy[p1:]
        if p2 < n:
            nums1[p1 + p2:] = nums2[p2:]
			

# @author:leacoder
# @des:  三指针 从后往前 合并两个有序数组
# 时间复杂度 : O(n + m)

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        # 双指针 从后往前
        p1 = m-1
        p2 = n-1
        p = m + n - 1 # 合并后 muns1 位置

        while p1 >= 0 and p2 >= 0:
            if nums1[p1] < nums2[p2]:
                nums1[p] = nums2[p2] # 从后先放入大的
                p2 -= 1
            else:
                nums1[p] =  nums1[p1]
                p1 -= 1
            p -= 1

        # 处理 剩余元素
        nums1[:p2 + 1] = nums2[:p2 + 1]		