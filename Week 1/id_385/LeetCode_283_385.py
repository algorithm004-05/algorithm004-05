# -*- encoding: utf-8 -*-
"""
    package.module
    ~~~~~~~~~~~~~~

    LeetCode 第283题: 移动零

    :copyright: (c) 2019-10-17 by liuyajing.
    :license: OPS, see LICENSE_FILE for more details.
"""


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
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = j = 0
        while j < len(nums):

            if nums[i] == 0:
                nums.append(0)
                del nums[i]
            else:
                i += 1

            j += 1

# leetcode submit region end(Prohibit modification and deletion)
