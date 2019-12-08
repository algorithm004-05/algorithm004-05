class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        res_map = {}

        for i, val in enumerate(nums):

            search_target = target - val

            if search_target in res_map:
                return [res_map[search_target], i]

            res_map[val] = i