# 第一遍
# 递归法
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
                helper(left + 1, right, s + "(")         #重复的地方
            if right < left:
                helper(left, right + 1, s + ")")
        
        left, right, s = 0, 0, ""                        #初始为空
        helper(left, right, s)
        return res