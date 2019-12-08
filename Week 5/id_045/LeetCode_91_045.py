#@author:leacoder
#@des:  动态规划  解码方法

'''
动态规划：

a、重复子问题
   
b、状态定义
dp[i] : 表示前 i 个字符组成的子串，有多少种解码方法

c、dp 方程
若 s[i-1] != '0' , dp[i] = dp[i - 1] （i 单字符编码）
若 s[i - 2: i] 在 10 到 26 之间 , dp[i] += dp[i - 2] （i-1 与 i 双字符编码）

注意
dp[1] :  if s[0] == "0" dp[1] = 0
            else  dp[1] = 1

'''

class Solution:
    def numDecodings(self, s: str) -> int:
        length = len(s)
        if length == 0:
            return length
        dp = [0]*(length+1)
        dp[0] = 1
        if s[0] == "0":
            dp[1] = 0
        else:
            dp[1] = 1

        for i in range(2,length+1):
            if s[i-1]!="0":
                dp[i] = dp[i - 1]
            if "10"<=s[i-2:i]<="26":
                dp[i] += dp[i-2]
        return dp[length]