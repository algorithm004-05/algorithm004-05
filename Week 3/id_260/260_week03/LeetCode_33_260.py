class Solution(object):
    def search(self, nums, target):
        if not nums:
            return -1
        l, r = 0, len(nums) - 1
        while l + 1 < r:
            mid = l + (r - l)/2
            if target == nums[mid]:
                return mid
            if nums[mid] > nums[r]:
                if target <= nums[mid] and target >= nums[l]:
                    r = mid
                else:
                    l = mid
            else:
                if target >= nums[mid] and target <= nums[r]:
                    l = mid
                else:
                    r = mid
        return l if target == nums[l] else r if target == nums[r] else -1