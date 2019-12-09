#!/anaconda3/bin/python
# -*- coding: utf-8 -*-

import collections

class Solution(object):

    @staticmethod
    def lengthOfLongestSubstring(s):
        d = collections.defaultdict(int)
        l = ans = 0
        for i, c in enumerate(s):
            while l > 0 and d[c] > 0:
                d[s[i-l]] -= 1
                l -= 1
            d[c] += 1
            l += 1
            ans = max(ans, l)
        return ans

    @staticmethod
    def _lengthOfLongestSubstring(s):
        d = {}
        start = 0
        ans = 0
        for i,c in enumerate(s):
            if c in d:
                start = max(start, d[c] + 1)
            d[c] = i
            ans = max(ans, i - start + 1)
        return ans

if __name__ == '__main__':
    print(Solution.lengthOfLongestSubstring("aaaaaa"))
    print(Solution._lengthOfLongestSubstring("asdfasdfx"))
