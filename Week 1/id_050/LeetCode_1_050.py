class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        _hash = {}
        for i in range(len(nums)):
            if nums[i] in _hash:
                return [_hash[nums[i]], i]
            else:
                _hash[target - nums[i]] = i
        return [-1, -1]
