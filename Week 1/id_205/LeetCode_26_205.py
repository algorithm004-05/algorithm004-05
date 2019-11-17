class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        pre,cur=0,1
        while cur<len(nums):       
            if nums[pre]==nums[cur]:
                nums.pop(cur)
            else:
                pre,cur=pre+1,cur+1
        return len(nums)