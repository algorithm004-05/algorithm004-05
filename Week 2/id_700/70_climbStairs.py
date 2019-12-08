# 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
#
# 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
#
# 注意：给定 n 是一个正整数。
#
# 示例 1：
#
# 输入： 2
# 输出： 2
# 解释： 有两种方法可以爬到楼顶。
# 1.  1 阶 + 1 阶
# 2.  2 阶

##### fibonicc
#
# class Solution:
#     def climbStairs(self, n: int) -> int:
#         fib, count = [1, 2], 2
#         while count < n:
#             fib.append(fib[count - 1] + fib[count - 2])
#             count += 1
#         return fib[n - 1]

# f(1) = 1
# f(2) = 2
# f (3) = f(1)+f(2)
# f(n)= f(n-2)+f(n-1)


class Solution:
    def climbStairs(self, n: int) -> int:
        if n ==1:
            return 1
        if n ==2:
            return 2
        return self.climbStairs(n-1)+self.climbStairs(n-2)



#
# class Solution:
#     def climbStairs(self, n: int) -> int:
#         if n < 1:
#             return 0
#         memory = {}
#         memory[1] = 1
#         memory[2] = 2
#         for i in range(3, n + 1):
#             memory[i] = memory[i - 1] + memory[i - 2]
#         return memory[n]
#
#
# 作者：tiac
# 链接：https: // leetcode - cn.com / problems / climbing - stairs / solution / 70 - pa - lou - ti - by - tiac /
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

  ###########   傻递归

    #
    #
    #######    学习别人的代码
    #  Top down - TLE
# def climbStairs1(self, n):
#     if n == 1:
#         return 1
#     if n == 2:
#         return 2
#     return self.climbStairs(n - 1) + self.climbStairs(n - 2)
#
#
# # Bottom up, O(n) space
# def climbStairs2(self, n):
#     if n == 1:
#         return 1
#     res = [0 for i in xrange(n)]
#     res[0], res[1] = 1, 2
#     for i in xrange(2, n):
#         res[i] = res[i - 1] + res[i - 2]
#     return res[-1]
#
#
# # Bottom up, constant space
# def climbStairs3(self, n):
#     if n == 1:
#         return 1
#     a, b = 1, 2
#     for i in xrange(2, n):
#         tmp = b
#         b = a + b
#         a = tmp
#     return b
#
#
# # Top down + memorization (list)
# def climbStairs4(self, n):
#     if n == 1:
#         return 1
#     dic = [-1 for i in xrange(n)]
#     dic[0], dic[1] = 1, 2
#     return self.helper(n - 1, dic)
#
#
# def helper(self, n, dic):
#     if dic[n] < 0:
#         dic[n] = self.helper(n - 1, dic) + self.helper(n - 2, dic)
#     return dic[n]
#
#
# # Top down + memorization (dictionary)
# def __init__(self):
#     self.dic = {1: 1, 2: 2}
#
#
# def climbStairs(self, n):
#     if n not in self.dic:
#         self.dic[n] = self.climbStairs(n - 1) + self.climbStairs(n - 2)
#     return self.dic[n]