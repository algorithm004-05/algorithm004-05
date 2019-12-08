#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#
# https://leetcode-cn.com/problems/longest-valid-parentheses/description/
#
# algorithms
# Hard (28.37%)
# Likes:    386
# Dislikes: 0
# Total Accepted:    27.6K
# Total Submissions: 96.3K
# Testcase Example:  '"(()"'
#
# 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
# 
# 示例 1:
# 
# 输入: "(()"
# 输出: 2
# 解释: 最长有效括号子串为 "()"
# 
# 
# 示例 2:
# 
# 输入: ")()())"
# 输出: 4
# 解释: 最长有效括号子串为 "()()"
# 

# 暴力法
'''
1 中间有效括号问题，从单侧开始循环，到遍历完，发现后半截子序列不合法无法回退，所以单侧循环需要一个缓存来记录序列索引。
2 

'''
# 
#

# @lc code=start
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        # 第一，找到成组的括号序号
        if not s:
            return 0
        res = [] #存储序号
        stasck = []
        for i in range(len(s)):
            if s[i] == '(':
                stasck.append(i)
            if stasck and s[i] == ')':
                res.append(stasck.pop())
                res.append(i)
        res.sort()
        i = 0 # 子串开始位置
        ans = 0 #子串长度
        n = len(res)
        while i < n:
            j = i
            while j<n-1 and res[j+1] == res[j]+1:
                j+=1
            ans = max(ans,j-i+1)
            i=j+1
        return ans 

        
# @lc code=end

