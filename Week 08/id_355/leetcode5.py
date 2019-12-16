class Solution(object):
    def longestPalindrome(self, s):
        res = ""
        for i in range(len(s)):
            t = self.helper(s, i, i)
            if len(t) > len(res):
                res = t
            t = self.helper(s, i, i+1)
            if len(t) > len(res):
                res = t
        return res

    def helper(self, s, l, r):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1; r += 1
        return s[l+1: r]