# @author:leacoder
# @des:  排序法 求众数  时间复杂度 O（nlg(n)）

class Solution:
    def majorityElement(self, nums: List[int]) -> int: 
        nums.sort()
        return nums[int(len(nums)/2)]  #条件>n/2，所以排序后，中间元素一定是众数

# @author:leacoder
# @des:  dic 求众数
'''
统计出现的次数
'''
class Solution:
    def majorityElement(self, nums: List[int]) -> int: 
        dic = {}
        for num in nums:
            if num in dic:
                dic[num] = dic[num]+1
            else:
                dic[num] = 1
        length = len(nums)
        for num in dic:
            if dic[num]>int(length/2):
                return num
    
# @author:leacoder
# @des:  摩尔投票法 求众数

class Solution:
    def majorityElement(self, nums: List[int]) -> int: 
        moore = 0
        count = 0
        for num in nums:  #由于给定的数组总是存在众数。 众数 与 非众数 抵消后最后 count必然>0
            if count == 0:
                moore = num #最终 moore 存放的就是众数
            if num == moore:
                count +=1  #重复一次 +1
            else:
                count -=1 #出现其他数据 -1
        return moore



# @author:leacoder
# @des:  分治 求众数

class Solution:
    def majorityElement(self, nums: List[int]) -> int: 
        def helper(left,right):
            if left == right:
                return nums[right]

            mid = (right-left)//2 + left

            leftval = helper(left, mid)
            rightval = helper(mid+1, right)

            if left == right:
                return left
            left_count = sum(1 for i in range(left, right+1) if nums[i] == leftval)
            right_count = sum(1 for i in range(left, right+1) if nums[i] == rightval)

            return leftval if left_count > right_count else rightval

        return helper(0, len(nums)-1)