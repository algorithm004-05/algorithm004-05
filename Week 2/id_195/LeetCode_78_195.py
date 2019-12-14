class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        n = len(nums)

        def _helper(i, tmp):
            res.append(tmp)
            for j in range(i, n):
                _helper(j + 1, tmp + [nums[j]])
        _helper(0, [])
        return res

class Solution:
    def subsets(self, nums):
        res = [[]]
        for i in nums:
            res += [[i] + num for num in nums]
        return res