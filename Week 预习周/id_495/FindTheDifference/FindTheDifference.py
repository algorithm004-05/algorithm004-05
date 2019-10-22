#!/anaconda3/bin/python
# -*- coding: utf-8 -*-

class Solution(object):

    @staticmethod
    def findTheDifference(s, t):
        """
        将原来的字符串拆分为单个字符，计算他们的和之差就是新加入的字符byte
        """
        sum1 = sum(map(ord, [c for c in s]))
        sum2 = sum(map(ord, [c for c in t]))
        return chr(sum2 - sum1)

if __name__ == '__main__':
    print(Solution.findTheDifference("asdf","sdxfa"))
