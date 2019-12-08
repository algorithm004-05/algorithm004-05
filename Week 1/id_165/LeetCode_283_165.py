#-*- encoding: utf-8 -*-

# 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
#
# 示例:
#
# 输入: [0,1,0,3,12]
# 输出: [1,3,12,0,0]
#
# 说明:
#
#
# 必须在原数组上操作，不能拷贝额外的数组。
# 尽量减少操作次数。
#
# Related Topics 数组 双指针


# leetcode submit region begin(Prohibit modification and deletion)
# class Solution(object):
#     def moveZeroes(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: None Do not return anything, modify nums in-place instead.
#         """
#
#         j = 0
#
#         for idx, d in enumerate(nums):
#
#             if d != 0:
#                 nums[j] = nums[idx]
#                 if j != idx:
#                     nums[idx] = 0
#                 j只有在d!=0时才移动，d=0时不动，所以d其实就是指向0
#                 j += 1
#


class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        zeroCount = 0

        for idx, d in enumerate(nums):

            if d == 0:
                zeroCount += 1
            elif zeroCount != 0:
                nums[idx - zeroCount] = d
                nums[idx] = 0


class Solution2(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        zeroP = -1

        for idx , data in enumerate(nums):

            if data == 0 and zeroP == -1:
                zeroP = idx

            elif data != 0 and zeroP > -1:
                nums[zeroP] = data
                nums[idx] = 0
                zeroP += 1
                if data[zeroP] != 0:
                    zeroP = -1

# leetcode submit region end(Prohibit modification and deletion)


