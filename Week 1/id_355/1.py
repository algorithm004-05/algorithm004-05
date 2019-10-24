class Solution(object):
    def twoSum(self, nums, target):
        buf = {}
        for i, n in enumerate(nums):
            if  n in buf:
                return [buf[n],i]
            buf[target - n] = i



