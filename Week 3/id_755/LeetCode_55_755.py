class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums is None:
            return False
        last_reachable = len(nums) - 1
        for i in range(len(nums)-1, -1, -1):
            if nums[i] + i >= last_reachable:
                last_reachable = i
        return last_reachable == 0
