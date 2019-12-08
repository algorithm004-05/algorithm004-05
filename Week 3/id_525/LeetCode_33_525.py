class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums: return -1
        rot = self.find_min_index(nums)
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            realmid = (rot + mid) % len(nums)
            if nums[realmid] == target:
                return realmid
            elif nums[realmid] > target:
                r = mid - 1
            else:
                l = mid + 1
        return -1

    def find_min_index(self, nums):
        l, r = 0, len(nums) - 1
        while l < r:
            mid = (l + r) // 2
            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid
        return l
