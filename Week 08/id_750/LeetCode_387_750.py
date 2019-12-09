"""
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
"""
import collections


class Solution:
    def firstUniqChar(self, s: str) -> int:
        count = collections.Counter(s)

        index = 0
        for ch in s:
            if count[ch] == 1:
                return index
            else:
                index += 1
        return -1


if __name__ == '__main__':
    soulution = Solution()

    s = "leetcode"

    s1 = "loveleetcode"

    result = soulution.firstUniqChar(s1)

    print(result)
