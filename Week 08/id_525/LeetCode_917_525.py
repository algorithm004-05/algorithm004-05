class Solution(object):
    def reverseOnlyLetters(self, S):
        """
        :type S: str
        :rtype: str
        """
        l, r = 0, len(S) - 1
        array = list(S)
        while l < r:
            if not array[l].isalpha():
                l += 1
            elif not array[r].isalpha():
                r -= 1
            else:
                array[l], array[r] = array[r], array[l]
                l, r = l + 1, r - 1
        return ''.join(array)
