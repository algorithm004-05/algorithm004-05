# 给定一个没有重复数字的序列，返回其所有可能的全排列。
#
# 示例:
#
# 输入: [1,2,3]
# 输出:
# [
#  [1,2,3],
#  [1,3,2],
#  [2,1,3],
#  [2,3,1],
#  [3,1,2],
#  [3,2,1]
# ]
# Related Topics 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):

    def __init__(self):

        self.res = []
        self.cur = []
        self.size = 0

    def _dfs(self, nums):

        if len(self.cur) == self.size:
            self.res.append(self.cur[:])
            return

        for idx, n in enumerate(nums):
            if n is not None:
                # None相当于一个标记，表示这个数字已经被使用，则下次迭代就会跳过
                nums[idx] = None
                self.cur.append(n)
                self._dfs(nums)
                nums[idx] = n
                self.cur.pop()

    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.size = len(nums)
        self._dfs(nums)
        return self.res

# leetcode submit region end(Prohibit modification and deletion)
