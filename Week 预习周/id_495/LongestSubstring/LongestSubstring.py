#!/anaconda3/bin/python
# -*- coding: utf-8 -*-

class Solution(object):

    @staticmethod
    def lengthOfLongestSubstring(s):
        """
        无重复字符的最长字串
        """
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
    print(Solution.lengthOfLongestSubstring("ababcbb"))
