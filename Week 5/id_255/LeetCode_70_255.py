class Solution:
    def climbStairs(self, n: int) -> int:
        # dp[i]=dp[i-1]+dp[i-2]            
        # if n<=2:
        #     return n
        # dp=[1,2]
        # for i in range(2,n):
        #     dp.append(dp[i-1]+dp[i-2])
        # return dp[n-1]
        
        f = [1, 2]
        for i in range(2, n):
            f.append(f[i-1] + f[i-2])
        return f[n-1]
        