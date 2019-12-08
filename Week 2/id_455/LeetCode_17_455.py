#
# @lc app=leetcode.cn id=17 lang=python3
#
# [17] 电话号码的字母组合
#

# @lc code=start
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        letterMap = {'2' : 'abc',
                     '3' : 'def',
                     '4' : 'ghi',
                     '5' : 'jkl',
                     '6' : 'mno',
                     '7' : 'pqrs',
                     '8' : 'tuv',
                     '9' : 'wxyz'
                    }
        if not digits: return []
        ls1 = ['']
        for c in digits:
            ls1 = [x + y for x in ls1 for y in letterMap[c]]
        return ls1

# @lc code=end

