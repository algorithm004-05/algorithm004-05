#!/anaconda3/bin/python
# -*- coding: utf-8 -*-

class Solution(object):

    """
    按奇偶校验排序数组
    """
    @staticmethod
    def sortArrayByParity(A):
        n = len(A)
        if n == 0 or n == 1:
            return A
        i = 0
        j = n - 1
        while i < j:
            if A[i] % 2 == 1 and A[j] % 2 == 0:
                A[i],A[j] = A[j],A[i]
            if A[i] % 2 == 0:
                i += 1
            if A[j] % 2 == 1:
                j -= 1
        return A

if __name__ == '__main__':
    print(Solution.sortArrayByParity([1,2,3,4,5,6]))
