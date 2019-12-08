# 字符串中的第一个唯一字符

class Solution:
    def firstUniqChar(self, s: str) -> int:
        dic = collections.defaultdict(int)
        for i in s:
            dic[i] += 1
        for i, ch in enumerate(s):
            if dic[ch] == 1:
                return i
        return -1