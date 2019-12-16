# 爬楼梯
# 法一：暴力法——傻递归 O(2^n) 超时
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        def helper(n):
            # terminator 
            if n <= 2:
                return n
            # process the current logic
            return helper(n-1) + helper(n-2)
        
        return helper(n)        