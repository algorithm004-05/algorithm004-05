# 括号生成
# 法一：递归
class Solution:
    def generateParenthesis(self, n):
        res = []
        def helper(left, right, s):
            # terminator
            if left == n and right == n:
                res.append(s)
                return
            # process current logic
            # drill down
            if left < n:
                helper(left+1, right, s+'(')
            if right < left and right < n:
                helper(left, right+1, s+')')
            
        helper(0, 0, "")
        return res
        
# 法二：动态规划
# a.重复性
# b.定义状态：使用i对括号能够生成的组合
# c.DP方程：dp[i] = "(" + dp[j] + ")" + dp[i-j-1], j = 0, 1, ..., i-1 
from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []
        # 创建一维数组
        dp = [None for _ in range(n + 1)]
        # 初始化一维数组
        dp[0] = [""]
        # 填充剩余位置
        for i in range(1, n + 1):
            cur = []
            for j in range(i):
                # DP方程
                left = dp[j]
                right = dp[i - j - 1]
                for s1 in left:
                    for s2 in right:
                        cur.append("(" + s1 + ")" + s2)
            dp[i] = cur
        return dp[n]

