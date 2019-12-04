# 26. 删除排序数组中的重复项
# 使用双指针-->快慢指针
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        for j in range(1,len(nums)):
            if nums[j] != nums[i]:                
                nums[i] = nums[j]
                i+=1
        return i + 1 