# 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
#
# 返回滑动窗口中的最大值。
#
#
#
# 示例:
#
# 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
# 输出: [3,3,5,5,6,7]
# 解释:
#
#  滑动窗口的位置                最大值
# ---------------               -----
# [1  3  -1] -3  5  3  6  7       3
# 1 [3  -1  -3] 5  3  6  7       3
# 1  3 [-1  -3  5] 3  6  7       5
# 1  3  -1 [-3  5  3] 6  7       5
# 1  3  -1  -3 [5  3  6] 7       6
# 1  3  -1  -3  5 [3  6  7]      7
#
#
#
# 提示：
#
# 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
#
#
#
# 进阶：
#
# 你能在线性时间复杂度内解决此题吗？
# Related Topics 堆 Sliding Window


# leetcode submit region begin(Prohibit modification and deletion)

from collections import deque

class Solution:
    def maxSlidingWindow1(self, nums: list, k: int) -> list:
        """
        暴力法
        :param nums:
        :param k:
        :return:
        """
        if len(nums) == 0:
            return []

        max_arr = []
        for i in range(k, len(nums)+1):
            max_arr.append(max(nums[i-k:i]))

        return max_arr

    def maxSlidingWindow2(self, nums: list, k: int) -> list:
        """
        双端队列
        :param nums:
        :param k:
        :return:
        """

        n = len(nums)
        if n * k == 0:
            return []
        if k == 1:
            return nums

        def clean_deque(i):
            # remove indexes of elements not from sliding window
            if deq and deq[0] == i - k:
                deq.popleft()

            # remove from deq indexes of all elements
            # which are smaller than current element nums[i]
            while deq and nums[i] > nums[deq[-1]]:
                deq.pop()

        deq = deque()
        max_idx = 0
        for i in range(k):
            clean_deque(i)
            deq.append(i)
            # compute max in nums[:k]
            if nums[i] > nums[max_idx]:
                max_idx = i
        output = [nums[max_idx]]

        # build output
        for i in range(k, n):
            clean_deque(i)
            deq.append(i)
            output.append(nums[deq[0]])

        return output









# leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    s = Solution()
    print(s.maxSlidingWindow2([1, 3, -1, -3, 5, 3, 6, 7], 3))
