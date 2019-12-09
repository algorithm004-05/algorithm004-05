## 338. 比特位计数

# 方法1
# class Solution(object):
#     def countBits(self, num):
#         return [bin(n).count('1') for n in range(num+1)]

# 方法2
class Solution(object):
    def countBits(self, num):
        arr = [0 for _ in range(num+1)]
        for n in range(1, num+1):
            arr[n] = arr[n & (n-1)] + 1
        return arr