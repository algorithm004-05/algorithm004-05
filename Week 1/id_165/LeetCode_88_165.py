# 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
#
# 说明:
#
#
# 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
# 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
#
#
# 示例:
#
# 输入:
# nums1 = [1,2,3,0,0,0], m = 3
# nums2 = [2,5,6],       n = 3
#
# 输出: [1,2,2,3,5,6]
# Related Topics 数组 双指针


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """

        tail_idx = m + n - 1
        nums1_tail = m - 1
        nums2_tail = n - 1

        for current_idx in range(start=tail_idx, stop=-1, step=-1):

            if nums2_tail < 0:
                break

            if nums1_tail >= 0 and nums1[nums1_tail] >= nums2[nums2_tail]:
                nums1[current_idx] = nums1[nums1_tail]
                nums1_tail -= 1
            else:
                nums1[current_idx] = nums2[nums2_tail]
                nums2_tail -= 1






# leetcode submit region end(Prohibit modification and deletion)
for i in range(9, -1, -1):
    print(i)