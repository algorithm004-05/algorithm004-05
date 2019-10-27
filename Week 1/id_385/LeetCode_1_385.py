# -*- encoding: utf-8 -*-
"""
    package.module
    ~~~~~~~~~~~~~~

    LeetCode 第1题: 两数之和

    :copyright: (c) 2019-10-20 by liuyj.
    :license: OPS, see LICENSE_FILE for more details.
"""


# 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
#
# 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
#
# 示例:
#
# 给定 nums = [2, 7, 11, 15], target = 9
#
# 因为 nums[0] + nums[1] = 2 + 7 = 9
# 所以返回 [0, 1]
#
# Related Topics 数组 哈希表


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 为数组中的数字建立索引
        num_map = {}
        for i in range(len(nums)):
            num_map[nums[i]] = i

        for i in range(len(nums)):
            if target - nums[i] in num_map and i != num_map[target - nums[i]]:
                return i, num_map[target - nums[i]]
# leetcode submit region end(Prohibit modification and deletion)
