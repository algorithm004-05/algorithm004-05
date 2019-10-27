# 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
#
# 示例 1:
#
# 输入: s = "anagram", t = "nagaram"
# 输出: true
# 示例 2:
#
# 输入: s = "rat", t = "car"
# 输出: false
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/valid-anagram
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

#####   2019/10/21 first try #######
#####     解题四件套：（1） clarification—— confirm information for detail 确认信息、细节
#####               （2）  possible solution —— optimal （time & space ) - which is my weakness
#####               （3）  code
#####               （2）  test case

#####    do not try only one time, repeat, repeat, repeat

#####   思路：1. 暴力求解，sort —— 按字符顺序sort，判断sorted_str 相等， 时间复杂度为 O（NlogN),

#####   思路：2. hash, 在Python中是dict 实现吧？（1）统计每个字符实现的频次，判断两个dict是否相等，（2）加一减一，判断最后的dict 是否empty
#####                                        （3） ASCII 存储 ——  这个不熟悉....

class Solution:
    def isAnagram(self, s, t):
        dic1, dic2 = {}, {}
        for item in s:
            dic1[item] = dic1.get(item, 0) + 1
        for item in t:
            dic2[item] = dic2.get(item, 0) + 1
        return dic1 == dic2


####   判断s,t 是否一样大小，再第二步判断

