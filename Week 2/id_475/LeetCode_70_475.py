# 第一遍
# 不存储中间变量，每次更新三个值
class Solution(object):
    def climbStairs(self, n):
        if n <= 2:
            return n
        f1, f2 = 1, 2
        for i in range(3,n+1):
            f3 = f1 + f2
            f1 = f2
            f2 = f3
        return f3