"""
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
"""


class Solution:
    # 方法1：把字符串转换成list，利用list中sort函数排序后进行比较
    # 观察国际大佬代码发现一行代码就能实现 return sorted(s) == sorted(t)，膜拜一下。
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        s_list = list(s)
        t_list = list(t)
        s_list.sort()
        t_list.sort()
        if s_list == t_list:
            return True
        else:
            return False

    # 方法2：利用map循环加减统计字符个数
    def isAnagram2(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        str_dict = dict()
        if s == "" and t == "":
            s = "a"
            t = "a"
        for i in range(len(s)):
            if s[i] not in str_dict:
                str_dict[s[i]] = 1
            else:
                str_dict[s[i]] += 1
            if t[i] not in str_dict:
                str_dict[t[i]] = -1
            else:
                str_dict[t[i]] -= 1
        result = min(str_dict.values())
        if result == 0:
            return True
        else:
            return False


if __name__ == '__main__':
    solution = Solution()
    s = "anagram"
    t = "nagaram"
    # result = solution.isAnagram(s, t)
    # print(result)

    result = solution.isAnagram2(s, t)

