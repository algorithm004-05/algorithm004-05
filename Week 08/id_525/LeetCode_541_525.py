class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        array = list(s)
        for i in range(0, len(array), 2 * k):
            array[i:i + k] = reversed(array[i:i + k])
        return ''.join(array)
