

from typing import List

# 时间复杂度 O(n)
class LeetCode_53_510:
    def maxSubArray(self, nums: List[int]) -> int:
        tmp = nums[0]
        max_ = tmp
        n = len(nums)
        for i in range(1,n):
            # 当前序列加上此时的元素的值大于tmp的值，说明最大序列和可能出现在后续序列中，记录此时的最大值
            if tmp >0:
                tmp += nums[i]
                max_ = max(max_, tmp)
            else:
            #当tmp(当前和)小于下一个元素时，当前最长序列到此为止。以该元素为起点继续找最大子序列,
            # 并记录此时的最大值
                tmp = nums[i]
                max_ = max(max_, tmp)
                
        return max_
    
    def maxSubArray1(self, nums: List[int]) -> int:
        for i in  range(1,len(nums)):
            nums[i] = max(nums[i],nums[i-1] + nums[i])
        return max(nums)


        
max_1 = LeetCode_53_510().maxSubArray1([-2,1,-3,4,-1,2,1,-5,4])
print(max_1)

