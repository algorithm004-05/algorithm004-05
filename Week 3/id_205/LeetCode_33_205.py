class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        if n == 0:
            return -1
        a = 0
        b = n - 1
        while a < b:
            mid = a + (b - a) // 2
            if nums[mid] == target:
                return mid
            elif nums[a] <= nums[mid]:
                if nums[a] <= target < nums[mid]:
                    b = mid - 1
                else:
                    a = mid + 1
            else:
                if nums[mid] < target <= nums[b]:
                    a = mid + 1
                else:
                    b = mid - 1
        #print(a,b)
        return a if nums[a] == target else -1
