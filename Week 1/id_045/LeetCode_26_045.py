# @author:leacoder
# @des:  双指针法  删除排序数组中的重复项

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        count = 0 # 慢指针
        for i in range(1,len(nums)): # 快指针
            if nums[i] != nums[count]:  # 不等
                count+=1    # 慢指针加一
                nums[count] = nums[i] # 将 nums[i] 赋值给 nums[count]
                
        return count+1