## 加一
# 方法一： 数组转数字  时间：O(n) 空间：O(n)
# class Solution:
#     def plusOne(self, digits: List[int]) -> List[int]:
#         length = len(digits)
#         sum = 0

#         for i in range(0, length):
#             sum += 10**(length - i - 1) * digits[i]
#         sum = list(str(sum+1))
#         return list(  map(int, sum)  )

##################################################################

# 方法二： 使用内置函数  时间：O(n) 空间：O(n)
# class Solution:
#     def plusOne(self, digits: List[int]) -> List[int]:
#         sum = int(''.join(list(map(str, digits)))) + 1
#         return list( map(int, list(str(sum))) )

################################################################

# 方法三： 冒泡法 时间：O(n) 空间：O(1)

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        i = len(digits)
        digits[i-1] += 1
        while i > 1:
            i -= 1
            if digits[i] >= 10:
                digits[i] = (digits[i]) % 10
                digits[i-1] += 1
        if digits[0] >= 10:
            digits[0] = digits[0] % 10
            digits.insert(0, 1)
        return digits