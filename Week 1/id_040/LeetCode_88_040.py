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
        比较插入法
        Do not return anything, modify nums1 in-place instead.
        """

        # 这里需要保证最后合并到的数组是nums1
        nums3 = nums1[:m]
        nums1[:] = []

        i1 = i2 = 0
        while i2 < n and i1 < m:
            if nums3[i1] < nums2[i2]:
                nums1.append(nums3[i1])
                i1 += 1
            else:
                nums1.append(nums2[i2])
                i2 += 1

        if i2 >= n:
            nums1.extend(nums3[i1:])

        if i1 >= m:
            nums1.extend(nums2[i2:])


# leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    s = Solution()

    nums1 = [0]
    m = 0
    nums2 = [1]
    n = 1

    s.merge(nums1, m, nums2, n)

    print(nums1)
