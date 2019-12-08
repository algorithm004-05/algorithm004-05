#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False

        dic = {}
        for i in s:
            if i in dic:
                dic[i] +=1
            else:
                dic[i] = 1
        
        for j in t:
            if j not in dic: return False
            if dic[j] <= 1:
                dic.pop(j)
            else:
                dic[j] -= 1
        return not dic