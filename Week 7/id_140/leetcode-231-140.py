class Solution:
    def isPowerOfTwo(self, n):
        if n==1:
            return True
        tmp=1
        while n > tmp:
            tmp=tmp<<1
            if tmp==n:
                return True
        return False