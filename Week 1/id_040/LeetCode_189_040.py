# 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
#
# 示例 1:
#
# 输入: [1,2,3,4,5,6,7] 和 k = 3
# 输出: [5,6,7,1,2,3,4]
# 解释:
# 向右旋转 1 步: [7,1,2,3,4,5,6]
# 向右旋转 2 步: [6,7,1,2,3,4,5]
# 向右旋转 3 步: [5,6,7,1,2,3,4]
#
#
# 示例 2:
#
# 输入: [-1,-100,3,99] 和 k = 2
# 输出: [3,99,-1,-100]
# 解释:
# 向右旋转 1 步: [99,-1,-100,3]
# 向右旋转 2 步: [3,99,-1,-100]
#
# 说明:
#
#
# 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
# 要求使用空间复杂度为 O(1) 的 原地 算法。
#
# Related Topics 数组


# leetcode submit region begin(Prohibit modification and deletion)

# 第一遍 2019年10月16日
class Solution:
    def rotate1(self, nums: list, k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        暴力法
        """
        l = len(nums)
        if k > l:
            k = k % l

        for i in range(k):
            n = nums.pop()
            nums.insert(0, n)

    def rotate2(self, nums: list, k: int) -> None:
        """
        暴力倒着来
        :param nums:
        :param k:
        :return:
        """
        l = len(nums)
        if k > l:
            k = k % l

        m = l - k

        for i in range(m):
            n = nums.pop(0)
            nums.append(n)

    def rotate3(self, nums: list, k: int) -> None:
        """

        :param nums:
        :param k:
        :return:
        """
        pass


# leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    s = Solution()
    nums = [1, 2, 3, 4, 5, 6, 7]
    print(s.rotate2(nums, 1))
    print(nums)
