#假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
#
# 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
#
# 注意：给定 n 是一个正整数。
#
# 示例 1：
#
# 输入： 2
#输出： 2
#解释： 有两种方法可以爬到楼顶。
#1.  1 阶 + 1 阶
#2.  2 阶
#
# 示例 2：
#
# 输入： 3
#输出： 3
#解释： 有三种方法可以爬到楼顶。
#1.  1 阶 + 1 阶 + 1 阶
#2.  1 阶 + 2 阶
#3.  2 阶 + 1 阶
#
# Related Topics 动态规划



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    # 第一遍 2019年10月14日
    def climbStairs(self, n: int) -> int:
        """
        :type n: int
        :rtype: int
        通过分析，该题的本质是求斐波那契数列
        """
        if n <= 2:
            return n

        f1, f2, f3 = 1, 2, 3
        for i in range(3, n + 1):
            f3 = f1 + f2
            f1 = f2
            f2 = f3

        return f3


#leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s = Solution()
    nums = 3
    print(nums)
    s.climbStairs(nums)
    print(nums)