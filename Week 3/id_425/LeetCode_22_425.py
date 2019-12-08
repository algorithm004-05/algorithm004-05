#
# @lc app=leetcode.cn id=22 lang=python3
#
# [22] 括号生成
#
# https://leetcode-cn.com/problems/generate-parentheses/description/
#
# algorithms
# Medium (72.07%)
# Likes:    581
# Dislikes: 0
# Total Accepted:    49.1K
# Total Submissions: 68K
# Testcase Example:  '3'
#
# 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
# 
# 例如，给出 n = 3，生成结果为：
# 
# [
# ⁠ "((()))",
# ⁠ "(()())",
# ⁠ "(())()",
# ⁠ "()(())",
# ⁠ "()()()"
# ]
# 
# 
#

# @lc code=start
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ret =[]
        s='('
        l,r=1,0
        def helper(s,l,r,n):
            if len(s) == 2*n:
                ret.append(s)
                return
            if l<n:
                helper(s+'(',l+1,r,n)
            if r<l:
                helper(s+')',l,r+1,n)
        helper(s,l,r,n)
        return ret
        
# @lc code=end

