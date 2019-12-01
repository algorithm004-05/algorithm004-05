# LeetCode 62 不同路径
# 第一遍
# DP：自底向上
# 法一：
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # 创建二维数组
        opt = [ [0 for _ in range(n)] for _ in range(m)]
        # 创建初始值
        for j in range(n):
            opt[0][j] = 1
        for i in range(m):
            opt[i][0] = 1
        # 填充剩余的格子
        for i in range(1,m):
            for j in range(1,n):
                opt[i][j] = opt[i][j-1] + opt[i-1][j]
        # 返回不同路径数
        return opt[m-1][n-1]

# 法二：代码优化 只存储当前行和上一行
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # 初始化：创建两个一维数组
        pre = [1] * n
        cur = [1] * n
        for _ in range(1,m): # 运行m-1次得到最后一行
            for j in range(1,n):  # 当前行的数由上一行填写
                cur[j] = cur[j-1] + pre[j]
            pre = cur[:] # 每填完一行就更新上一行
        return cur[-1]

# 法三：在法二的代码上进行改进
# 可观察到cur[j] = cur[j-1] + pre[j],由于pre初值和cur一样，且每次要更新pre，故可写为cur[j] = cur[j-1] + cur[j]
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # 初始化：创建两个一维数组
        cur = [1] * n
        for _ in range(1,m): # 运行m-1次得到最后一行
            for j in range(1,n):  # 当前行的数由上一行填写
                cur[j] += cur[j-1]
        return cur[-1]