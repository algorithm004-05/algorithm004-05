# 不同路径
# 法一：暴力法（傻递归/分治） 超时
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        def f(m, n):
            if m <= 0 or n <= 0: return 0
            # terminator
            if m == 1 or n == 1: return 1
            # process the current logic
            # drill down
            return f(m-1,n) + f(m,n-1)
        
        return f(m, n)

# 法二：分治+记忆化搜索
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        def f(m, n):
            if m <= 0 or n <= 0: return 0
            # terminator
            if m == 1 or n == 1: mem[(m,n)] = 1
            # process the current logic
            # drill down
            if (m,n) not in mem:
                mem[(m,n)] = f(m-1,n) + f(m,n-1)
            return mem[(m,n)]
    
        mem = {}
        return f(m, n)

# 法三：DP 
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        # 创建并初始化数组
        dp = [[1] * n for _ in range(m)]
        # 填充剩余位置
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i][j-1] + dp[i-1][j] # DP方程
        return dp[m-1][n-1]