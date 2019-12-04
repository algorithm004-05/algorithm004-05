# 实现 int sqrt(int x) 函数。
#
# 计算并返回 x 的平方根，其中 x 是非负整数。
#
# 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
#
#
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/sqrtx
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

####  二分查找的模板
def binaryResearch(nums,target,):
    left, right = 0 ,len(nums)-1
    while left <= right:
        mid = left +(right - left +1 )//2
        if nums[mid] == target:
            return result
        if nums[mid] < target:
            left = mid +1
        if nums[mid] > target:
            right = mid -1

class Solution:
    def mySqrt(self,x):
        left = 0
        right = x
        while left <= right:
            mid = left+(right-left+1)//2
            if mid*mid <= x <(mid+1)*(mid + 1):   ######这一步不仅要找到mid,还要找如果mid不是整数时向下取整
                return mid
            elif mid**2 < x:
                left = mid +1
            elif mid**2 > x:
                right = mid - 1


class Solution:
    def mySqrt(self,x):
        left , right = 0 , x
        while left <= right:
            mid = left +(right - left)//2
            if mid*mid <= x <(mid+1)*(mid + 1):
                return mid
            elif mid*mid < x:
                right = mid
            else:
                left = mid-1