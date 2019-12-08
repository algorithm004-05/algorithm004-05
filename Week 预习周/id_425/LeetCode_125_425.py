#
# @lc app=leetcode.cn id=125 lang=python3
#
# [125] 验证回文串
#
# https://leetcode-cn.com/problems/valid-palindrome/description/
#
# algorithms
# Easy (41.16%)
# Likes:    120
# Dislikes: 0
# Total Accepted:    56K
# Total Submissions: 136.1K
# Testcase Example:  '"A man, a plan, a canal: Panama"'
#
# 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
# 
# 说明：本题中，我们将空字符串定义为有效的回文串。
# 
# 示例 1:
# 
# 输入: "A man, a plan, a canal: Panama"
# 输出: true
# 
# 
# 示例 2:
# 
# 输入: "race a car"
# 输出: false
# 
# 
#
import re
# @lc code=start
class Solution:
    def isPalindrome(self, s):
        #高层次代码
        filtereds = self._filterNoNumberAndStr(s)#过滤其他字符
        reverseds = self._reversString(filtereds)
        print(reverseds)
        return reverseds == self._filterNoNumberAndStr(s)
    def _filterNoNumberAndStr(self, s):
        # s = re.sub(r'\s?\:?\,?\.?\@?\#?\-?\??\\?\'?\"?\;?\!?\(?\)?\[?\]?\{?\}?\`?\~?','',s)
        s = re.sub(r'\W?\_?','',s)
        s = s.lower()
        return s
    def _reversString(self , s):
        s = s[::-1]
        return s
# @lc code=end
# So = Solution() 
# print(So.isPalindrome('A man, a plan, a canal: Panama'))
