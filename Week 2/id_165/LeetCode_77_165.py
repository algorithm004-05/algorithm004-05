# 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
#
# 示例:
#
# 输入: n = 4, k = 2
# 输出:
# [
#  [2,4],
#  [3,4],
#  [2,3],
#  [1,2],
#  [1,3],
#  [1,4],
# ]
# Related Topics 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):

    def __init__(self):

        self.res = []
        self.current = []

    def combine_next(self, start, end, k):

        if len(self.current) == k:
            self.res.append(self.current[:])
            return

        for i in range(start, end + 1):
            self.current.append(i)
            self.combine_next(i + 1, end, k)
            self.current.pop()

    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        self.combine_next(1, n, k)
        return self.res

# leetcode submit region end(Prohibit modification and deletion)
