class Solution:
    def canJump(self, nums: List[int]) -> bool:
    	n = len(nums)
    	if n <= 1:
    		return True
    	fp = nums[0]
    	for i in range(n):
    		if fp >= n-1:
    			return True
    		if fp >= i:
    			fp = max(fp,nums[i]+i)
    	return False