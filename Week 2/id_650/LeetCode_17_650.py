#
# @lc app=leetcode.cn id=17 lang=python3
#
# [17] 电话号码的字母组合
#
# https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
#
# algorithms
# Medium (51.22%)
# Likes:    480
# Dislikes: 0
# Total Accepted:    53K
# Total Submissions: 103.5K
# Testcase Example:  '"23"'
#
# 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
# 
# 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
# 
# 
# 
# 示例:
# 
# 输入："23"
# 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
# 
# 
# 说明:
# 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
# 
#

# @lc code=start
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        res = []

        def generator(curr_i = 0, s=""):
            if curr_i == len(digits):
                res.append(s)
                return
            for i in difits_map[digits[curr_i]]:
                generator(curr_i+1, s + i)

        difits_map = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }
        # strs = ''
        # strs = [strs + difits_map[digits[num]] for num in digits];
        if digits:
            generator()
        return res


# @lc code=end

