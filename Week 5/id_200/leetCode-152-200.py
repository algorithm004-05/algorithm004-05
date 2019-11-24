#152. 乘积最大子序列



class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if nums is None: return 0
        res,curmax,curmin=nums[0],nums[0],nums[0]
        for i in range(1,len(nums)):
            if nums[i]<0: curmax,curmin=curmin,curmax
            curmax=max(curmax*nums[i],nums[i])
            curmin=min(curmin*nums[i],nums[i])
            res=max(res,curmax)
        return res