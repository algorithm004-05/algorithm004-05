#
# @lc app=leetcode.cn id=62 lang=python3
#
# [62] 不同路径
#
# https://leetcode-cn.com/problems/unique-paths/description/
#
# algorithms
# Medium (56.81%)
# Likes:    352
# Dislikes: 0
# Total Accepted:    51.4K
# Total Submissions: 89.8K
# Testcase Example:  '3\n2'
#
# 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
# 
# 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
# 
# 问总共有多少条不同的路径？
# 
# 
# 
# 例如，上图是一个7 x 3 的网格。有多少可能的路径？
# 
# 说明：m 和 n 的值均不超过 100。
# 
# 示例 1:
# 
# 输入: m = 3, n = 2
# 输出: 3
# 解释:
# 从左上角开始，总共有 3 条路径可以到达右下角。
# 1. 向右 -> 向右 -> 向下
# 2. 向右 -> 向下 -> 向右
# 3. 向下 -> 向右 -> 向右
# 
# 
# 示例 2:
# 
# 输入: m = 7, n = 3
# 输出: 28
# 
#

# @lc code=start
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m <= 0 or n <= 0:return 0
        if m <=1 or n <= 1:return 1
        # 初始化dp状态数组
        dp = {}
        for i in range(m-1):
            dp[(i, n-1)] = 1
        for j in range(n-1):
            dp[(m-1, j)] = 1
        
        for i in range(m-2 ,-1, -1):
            for j in range(n-2, -1, -1):
                dp[(i, j)] = dp[(i+1, j)] + dp[(i, j+1)]
        
        return dp[(0,0)]
# @lc code=end

