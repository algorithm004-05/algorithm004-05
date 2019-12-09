class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        res = set()
        for i in s:
            res.add(i)

        for j in t:
            if j not in res:
                return False

        return True