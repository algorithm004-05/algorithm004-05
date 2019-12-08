##
 # 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 #
 # 示例:
 #
 # 输入: [10,9,2,5,3,7,101,18]
 # 输出: 4 
 # 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 # 说明:
 #
 # 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 # 你算法的时间复杂度应该为 O(n2) 。
 # 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 #
 # 来源：力扣（LeetCode）
 # 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 # 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 #/
from typing import List
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        len_ = len(nums)
        if len_ < 2:
            return len_
        # 最小至少为1
        dp = [1 for _ in range(len_)]
        for i in range (1,len_):
            for j in range(i):
                if(nums[i] > nums[j]):
                    dp[i] = max(dp[i],dp[j]+1)
        return max(dp)

    def lengthOfLIS1(self, nums: List[int]) -> int:
        len_ = len(nums)
        if len_ < 2:
            return len_
        lst = [0 for _ in range(len_)]
        size_ = 1
        left,right,mid = 0,size_,0
        lst[0] = nums[0]
        for i in range(1,len_):
            left,right = 0,size_-1
            #二分查找
            while left < right:
                mid = left + ((right-left)>>1)
                #print(left,mid,right)
                if lst[mid] < nums[i]:
                    left = mid + 1
                else:
                    right = mid
            if nums[i] > lst[right]: #补位
                size_+=1
                lst[size_-1] = nums[i]
            else: #替换
                lst[right]= nums[i]
        #print(lst)
        return size_

    def lengthOfLIS2(self, nums: List[int]) -> int:
        len_ = len(nums)
        lst = [0] * len_
        size_ = 0
        for num in nums:
            left,right = 0,size_
            #二分查找
            while left < right:
                mid = left + ((right-left)>>1)
                #print(left,mid,right)
                if lst[mid] < num: left = mid + 1
                else: right = mid
            lst[right]= num
            size_ = max(size_,right+1)
        #print(lst)
        return size_


print(Solution().lengthOfLIS2([10,9,2,5,3,7,101,18]))
print(Solution().lengthOfLIS2([10,11,12,13,1,2,3]))

