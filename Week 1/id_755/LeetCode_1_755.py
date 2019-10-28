# time complexity = O(n)
# space complexity = O(n)


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = dict()
        for i, n in enumerate(nums):
            if target - n in hashmap:
                return hashmap[target-n], i
            else:
                hashmap[n] = i
