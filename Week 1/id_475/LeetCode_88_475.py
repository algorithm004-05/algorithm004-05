# 法一：合并后排序,时间复杂度O((n+m)log(n+m))，并未利用数组有序的特点
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        for i in range(len(nums2)):
            nums1[m + i] = nums2[i] 
        return nums1.sort()

# 法二：双指针法：p1和p2得到每一步最小值，i记录修改nums1元素位置，修改为最小值，时间复杂度O(n+m)
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        nums1_copy = nums1[:m]
        p1, p2 = 0, 0
        i = 0
        while p1 < m and p2 < n:
            if nums1_copy[p1] <= nums2[p2]:
                nums1[i] = nums1_copy[p1]
                i += 1
                p1 += 1
            else:
                nums1[i] = nums2[p2]
                i += 1
                p2 += 1
        if p1 < m:
            nums1[p1 + p2:] = nums1_copy[p1:]
        if p2 < n:
            nums1[p1 + p2:] = nums2[p2:]
