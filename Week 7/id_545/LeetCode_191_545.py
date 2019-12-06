## 191. 位1的个数

class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        ## 方法1
        # count = 0 
        # while n > 0:
        #     count += 1
        #     n = n & (n - 1)
        # return count

        ## 方法2
        # count = 0
        # while n > 0:
        #     if n % 2 == 1:
        #         count += 1
        #     n = n // 2
        # return count

        ## 方法3
        count = 0
        while n > 0:
            if n & 1:
                count += 1
            n = n >> 1
        return count

        ## 方法4
        # return bin(n).count('1')