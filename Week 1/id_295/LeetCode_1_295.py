from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}
        for index, num in enumerate(nums):
            if num in d:
                return [d[num], index]
            d[target - num] = index


def test_answer():
    assert Solution().twoSum([2, 7, 11, 15], 9) == [0, 1]
