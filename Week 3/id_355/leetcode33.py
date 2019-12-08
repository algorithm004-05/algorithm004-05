class Solution(object):
    def search(self, nums, target):
        left = 0 ; right = len(nums) - 1
        while left < right:
            mid = (left + right)/2
            if nums[mid] >= nums[0] and (target < nums[0] or target > nums[mid]):
                left = mid +1
            elif target < nums[0] and target > nums[mid]:
                left = mid + 1
            else:
                right = mid
        if left == right and nums[left] == target:
            return left
        else:
            return -1