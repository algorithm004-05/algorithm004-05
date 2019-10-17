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

#
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def moveZeroes1(self, nums: list) -> None:
        """
        Do not return anything, modify nums in-place instead.

        1. 统计数组中0的个数
        2. 通过python的list.remove删除0，再在结尾加上0

        """
        zero_count = 0
        for n in nums:
            if n == 0:
                zero_count += 1

        for i in range(zero_count):
            nums.remove(0)
            nums.append(0)

    # 第一遍 2019年10月14日
    def moveZeroes2(self, nums: list) -> None:
        j = 0
        for i, n in enumerate(nums):
            if n != 0:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1



# leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    s = Solution()
    nums = [0, 1, 0, 2, 3, 0, 4]
    print(nums)
    s.moveZeroes2(nums)
    print(nums)