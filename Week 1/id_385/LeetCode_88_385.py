# -*- encoding: utf-8 -*-
"""
    package.module
    ~~~~~~~~~~~~~~

    LeetCode 第88题: 合并两个有序数组

    :copyright: (c) 2019-10-18 by liuyajing.
    :license: OPS, see LICENSE_FILE for more details.
"""


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
class Solution:
    def merge(self, nums1: list, m: int, nums2: list, n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        j = 0
        length = len(nums1)
        for num in nums2:
            for i in range(j, length):
                if nums1[i] > num:
                    for k in range(length - 1, i, -1):
                        nums1[k] = nums1[k - 1]
                    nums1[i] = num
                    m = m + 1
                    j = i
                    break
                elif nums1[i] is 0 and i >= m:
                    nums1[i] = num
                    m = m + 1
                    j = i
                    break

# leetcode submit region end(Prohibit modification and deletion)
