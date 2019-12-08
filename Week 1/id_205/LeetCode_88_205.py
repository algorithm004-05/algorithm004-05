class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if m == 0:
            nums1[:] = nums2
        elif n== 0:
            nums1[:] = nums1
        index_1, index_2, index = m - 1, n - 1, m + n - 1
        while index_1 >= 0 and index_2 >= 0:
            if nums1[index_1] < nums2[index_2]:
                nums1[index] = nums2[index_2]
                index_2 -= 1
            else:
                nums1[index] = nums1[index_1]
                index_1 -= 1
            index -= 1
        if index_2 >= 0 and nums2[index_2]<=nums1[0]:
            nums1[:index_2 + 1] = nums2[:index_2 + 1]