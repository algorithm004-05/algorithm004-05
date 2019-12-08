class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        result = 0
        while n !=0:
            result += 1
            n &= (n-1)
        return result