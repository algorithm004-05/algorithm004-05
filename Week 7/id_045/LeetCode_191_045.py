# @author:leacoder 
# @des: 32位均判断 位1的个数

class Solution(object):
    def hammingWeight(self, n):
        count = 0   #位1 计数
        mask = 1    #
        for i in range(32): #对32位  整数  每位判断
            if n & mask: #判断每个位是否为1
                count += 1
            mask = mask << 1  #左移移位
        return count
	
	
# @author:leacoder 
# @des: 利用X & (X-1)   位1的个数

# X & (X-1) 清零最低位的 1
class Solution(object):
    def hammingWeight(self, n):
        count = 0   #位1 计数
        while n:
            count += 1
            n = n & (n-1)   # X & (X-1) 清零最低位的 1
        return count