class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def findMin(self, nums):   
        lef = 0 
        rig = len(nums) - 1

        while lef < rig - 2: 
        	mid = (lef + rig) / 2
        	if nums[mid] > nums[rig]: 
        		lef = mid 
        	else:
        		rig = mid

        return min(nums[lef : rig+1]) 